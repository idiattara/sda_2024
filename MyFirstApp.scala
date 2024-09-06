import org.apache.spark.sql.SparkSession
object MyFirstApp{
  def main(args: Array[String]) {
    val csvFile="src/main/resources/datain/test.csv"

    val spark = SparkSession.builder.appName("SimpleApplication")
      .config("spark.master", "local")
      .getOrCreate()

    val df = spark.read
      .format("csv")
      .option("header", "true") // Si le fichier CSV contient un en-tête
      .load(csvFile)

    df.show()

  }
}
