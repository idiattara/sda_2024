package sda.reader

import org.apache.spark.sql.{DataFrame, SparkSession}

trait Reader  {
  val format: String
  def read()(implicit spark: SparkSession): DataFrame
}

