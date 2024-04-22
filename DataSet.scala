
import org.apache.spark.sql.{SparkSession, Dataset, Encoder}
import org.apache.spark.sql.Encoders
object DataSet {
  case class Employee(id: Int, name: String, age: Int, department: String, code: Option[Int]=None)
  def main(args: Array[String]): Unit = {
    // Création de la SparkSession
    val spark = SparkSession.builder()
      .appName("Word Count")
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._
    implicit val employeeEncoder: Encoder[Employee] = Encoders.product[Employee]

    def filterEmployees(data: Dataset[Employee], department: String): Dataset[Employee] = {
      data.filter(emp => emp.age > 30 && emp.department == department)
    }
    val employees: Dataset[Employee] = Seq(
      Employee(1, "John", 35, "HR", Some(13)),
      Employee(2, "Alice", 28, "IT"),
      Employee(3, "Bob", 40, "HR"),
      Employee(4, "Sarah", 32, "IT", Some(15)),
      Employee(5, "Michael", 38, "Finance", Some(12))
    ).toDS()
    // Filtrer les employés de plus de 30 ans dans le département "HR"
    val filteredEmployees = filterEmployees(employees, "HR")
    filteredEmployees.show()
  }
}
