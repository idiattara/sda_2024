package fr
import org.apache.spark.sql.SparkSession
object ErrorLogAnalyzer {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Error Log Analyzer")
      .master("local[*]")
      .getOrCreate()
    val sc = spark.sparkContext
    // Création d'un accumulateur pour compter le nombre de lignes contenant des erreurs
    val errorLinesCount = sc.longAccumulator("Error Lines Count")

    // Chargement du fichier de journal en tant que RDD de lignes
    val lines = sc.textFile("src/main/resources/datain/log.txt")

    // Transformation avec utilisation de l'accumulateur
    lines.foreach { line =>
      if (line.contains("ERROR")) {
        errorLinesCount.add(1) // Incrémentation de l'accumulateur si la ligne contient "ERROR"
      }
    }
    // Affichage du résultat
    println(s"Nombre de lignes contenant des erreurs : ${errorLinesCount.value}")

    spark.stop()
  }
}
