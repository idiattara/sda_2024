import org.apache.spark.sql.SparkSession
object Plan {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("GET PLAN")
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._
    val df=Seq(("toto", 12),("toto", 20),("toto", 23)).toDF("nom","age")
    val df2=df.filter($"age">18).drop("age")
    df2.show
    df2.explain("extended")

  }
}
