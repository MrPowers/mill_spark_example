package foo

import utest._
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions._
import com.github.mrpowers.spark.fast.tests.DatasetComparer

object ExampleTests extends TestSuite with SparkSessionTestWrapper with DatasetComparer {

  val tests = Tests {

    import spark.implicits._

    "withGreeting" - {

      val sourceDF = Seq(
        ("jose"),
        ("li"),
        ("luisa")
      ).toDF("name")

      val actualDF = sourceDF.transform(Example.withGreeting())

      val expectedDF = Seq(
        ("jose", "hello!"),
        ("li", "hello!"),
        ("luisa", "hello!")
      ).toDF("name", "greeting")

      assertSmallDatasetEquality(actualDF, expectedDF, ignoreNullable = true)

    }

  }

}
