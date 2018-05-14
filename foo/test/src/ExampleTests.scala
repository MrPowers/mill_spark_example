package foo

import utest._
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

object ExampleTests extends TestSuite with SparkSessionTestWrapper {

  val tests = Tests {

    'test1 - {
      assert(Example.greeting() == "hi")
    }

    'test2 - {
      assert(10 == 10)
    }

    "a dataframe can be built" - {
      val rows = spark.sparkContext.parallelize(
        List(
          Row(1.0, 2.0)
        )
      )

      val schema = List(
        StructField("id", DoubleType, true),
        StructField("features", DoubleType, true)
      )

      val df = spark.createDataFrame(
        rows,
        StructType(schema)
      )
    }

  }

}
