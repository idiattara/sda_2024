import org.apache.spark.sql.SparkSession

object BroadcastExample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Broadcast Example")
      .master("local[*]")
      .getOrCreate()

    val sc = spark.sparkContext

    // Création d'une variable à diffuser
    val data = Seq(1, 2, 3, 4, 5)
    val broadcastData = sc.broadcast(data)

    // Transformation avec utilisation de la variable diffusée
    val result = sc.parallelize(Seq(1, 2, 3))
      .map(x => x * broadcastData.value.sum) // Utilisation de la variable diffusée

    result.collect().foreach(println)

    spark.stop()
  }
}
