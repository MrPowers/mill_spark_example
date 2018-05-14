// build.sc
import mill._
import mill.scalalib._

object foo extends ScalaModule {
  def scalaVersion = "2.11.12"
  def ivyDeps = Agg(
    ivy"org.apache.spark::spark-sql:2.3.0"
  )

  object test extends Tests{
    def ivyDeps = Agg(
      ivy"com.lihaoyi::utest:0.6.0",
    )
    def testFrameworks = Seq("utest.runner.Framework")
  }
}
