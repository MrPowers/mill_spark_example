import mill._
import mill.scalalib._
import mill.modules.Assembly
import coursier.maven.MavenRepository

object foo extends ScalaModule {
  def scalaVersion = "2.11.12"

  override def compileIvyDeps = Agg(
    ivy"org.apache.spark::spark-sql:2.4.7"
  )

  override def ivyDeps = Agg(
    ivy"com.github.mrpowers::spark-daria:0.38.2"
  )

  override def assemblyRules = Assembly.defaultRules ++
    Seq("scala/.*", "org\\.apache\\.spark/.*")
      .map(Assembly.Rule.ExcludePattern.apply)

  object test extends Tests{
    override def ivyDeps = Agg(
      ivy"org.apache.spark::spark-sql:2.4.7",
      ivy"com.lihaoyi::utest:0.7.5",
      ivy"com.github.mrpowers::spark-fast-tests:0.21.3",
      ivy"com.github.mrpowers::spark-daria:0.38.2"
    )
    def testFrameworks = Seq("utest.runner.Framework")
  }
}
