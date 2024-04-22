import org.apache.spark.sql.SparkSession
object WordCountSparkSession {
  def main(args: Array[String]): Unit = {
    // Création de la SparkSession
    val spark = SparkSession.builder()
      .appName("Word Count")
      .master("local[*]") // exécution en mode local avec autant de threads que de cœurs disponibles
      .getOrCreate()
    import spark.implicits._
    // Chargement du fichier texte
    val lines = spark.read.textFile("src/main/resources/datain/test.txt").as[String]
    // Transformation des lignes en mots
    val words = lines.flatMap(_.split(" "))
    // Comptage des mots
    val wordCounts = words.groupBy("value").count()
    // Affichage des résultats
    wordCounts.show()
    // Arrêt de la SparkSession
    spark.stop()
  }
}

