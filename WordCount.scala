import org.apache.spark.{SparkConf, SparkContext}
object WordCount {
  def main(args: Array[String]): Unit = {
    // Configuration Spark
    val conf = new SparkConf()
      .setAppName("Word Count")
      .setMaster("local[*]") // exécution en mode local avec autant de threads que de cœurs disponibles
    // Création du SparkContext
    val sc = new SparkContext(conf)
    // Chargement du fichier texte
    val lines = sc.textFile("src/main/resources/datain/test.txt")
    // Transformation des lignes en mots
    val words = lines.flatMap(_.split(" "))
    // Comptage des mots
    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _)
    // Affichage des résultats
    wordCounts.foreach(println)
    // Arrêt du SparkContext
    sc.stop()
  }
}
