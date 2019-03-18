package foo

import utest._
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions._
import com.github.mrpowers.spark.fast.tests.DatasetComparer
import com.github.mrpowers.spark.daria.sql.SparkSessionExt._

object ExampleTests extends TestSuite with SparkSessionTestWrapper with DatasetComparer {

  val tests = Tests {

    import spark.implicits._

    "withGreeting" - {

      val sourceDF = spark.createDF(
        List(
          ("jose"),
          ("li"),
          ("luisa")
        ), List(
          ("name", StringType, true)
        )
      )

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
