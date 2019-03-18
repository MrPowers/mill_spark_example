package foo

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import com.github.mrpowers.spark.daria.sql.ColumnExt._

object Example {

  def withGreeting()(df: DataFrame): DataFrame = {
    df.withColumn("greeting", lit("hello!"))
  }

}
