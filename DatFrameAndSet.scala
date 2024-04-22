package fr
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, Dataset, Row}
import org.apache.spark.sql.functions.col
object DatFrameAndSet{
  def main(args: Array[String]): Unit = {
    // Création de la SparkSession
    val spark = SparkSession.builder()
      .appName("Word Count")
      .master("local[*]") // exécution en mode local avec autant de threads que de cœurs disponibles
      .getOrCreate()
    import spark.implicits._
    def getColumns1(data: DataFrame, columns: List[String]): DataFrame = {
      // Sélection des colonnes spécifiées
      val selectedColumns = columns.map(col)
      // Filtrage du DataFrame pour ne garder que les colonnes sélectionnées
      data.select(selectedColumns: _*)
    }

    def getColumns2(data: Dataset[Row] ,columns: List[String]): DataFrame = {
      val selectedColumns = columns.map(col)
      data.select(selectedColumns: _*)
    }
    val df=Seq(("fall",12,"paris"), ("diop",23,"marseille")).toDF("nom","age", "ville")
    getColumns1(df,List("nom","age")).show
    getColumns2(df,List("nom","age")).show
  }
}


