package sda.reader

import org.apache.spark.sql.{DataFrame, SparkSession}
case class CsvReader(path: String,
                     delimiter: Option[String] = None,
                     header:Option[Boolean] = None

                                 )
  extends Reader {
  val format = "csv"

  def read()(implicit  spark: SparkSession): DataFrame = {

      spark.read.format(format)
      .option("delimiter", delimiter.getOrElse(","))
      .option("header", header.getOrElse(true))
      .load(path)

  }
}
