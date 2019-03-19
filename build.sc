// build.sc
import mill._
import mill.scalalib._
import coursier.maven.MavenRepository

object foo extends ScalaModule {
  def scalaVersion = "2.11.12"

  def repositories = super.repositories ++ Seq(
    MavenRepository("http://dl.bintray.com/spark-packages/maven")
  )

  def ivyDeps = Agg(
    ivy"org.apache.spark::spark-sql:2.3.0",
    ivy"mrpowers:spark-daria:0.26.1-s_2.11"
  )

  def compileIvyDeps = Agg(
    ivy"org.apache.spark::spark-sql:2.3.0",
    ivy"mrpowers:spark-daria:0.26.1-s_2.11"
  )

  object test extends Tests{
    def ivyDeps = Agg(
      ivy"org.apache.spark::spark-sql:2.3.0",
      ivy"com.lihaoyi::utest:0.6.0",
      ivy"MrPowers:spark-fast-tests:0.17.1-s_2.11",
      ivy"mrpowers:spark-daria:0.26.1-s_2.11"
    )
    def testFrameworks = Seq("utest.runner.Framework")
  }
}
