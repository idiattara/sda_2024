package spark
import org.apache.spark.sql.SparkSession
object SparkApp  extends App {

  // Création de la session Spark
  val spark = SparkSession.builder
    .appName("TP Spark RDD")
    .master("local[*]")
    .getOrCreate()

  // Création du contexte Spark
  val sc = spark.sparkContext

  // Lecture du fichier texte en tant que RDD
  val filePath = "C:\\Users\\ibrah\\Downloads\\SalutationProcessor-master\\uvs1\\src\\data\\student.txt"
  val studentRDD = sc.textFile(filePath)
  println("Contenu brut du RDD :")
  studentRDD.collect().foreach(println)

  // Suppression de la première ligne (en-tête) si nécessaire
  val header = studentRDD.first()
  val dataRDD = studentRDD.filter(line => line != header)
  println("\nRDD après suppression de l'en-tête :")
  dataRDD.collect().foreach(println)

  // Transformation des données en objets structurés
  case class Student(id: Int, firstName: String, lastName: String, age: Int, city: String)

  val studentDataRDD = dataRDD.map { line =>
    val Array(id, firstName, lastName, age, city) = line.split(",")
    Student(id.toInt, firstName, lastName, age.toInt, city)
  }
  println("\nRDD transformé en objets Student :")
  studentDataRDD.collect().foreach(println)

  // 1. Nombre d'étudiants dans le RDD
  val numberOfStudents = studentDataRDD.count()
  println(s"\nNombre d'étudiants : $numberOfStudents")

  // 2. Affichage des 5 premiers étudiants
  val first5Students = studentDataRDD.take(5)
  println("\nLes 5 premiers étudiants :")
  first5Students.foreach(println)

  // 3. Calcul de l'âge moyen des étudiants
  val averageAge = studentDataRDD.map(_.age).mean()
  println(s"\nL'âge moyen des étudiants : $averageAge")

  // 4. Nombre d'étudiants par ville
  val studentsByCity = studentDataRDD.map(student => (student.city, 1))
    .reduceByKey(_ + _)
  println("\nNombre d'étudiants par ville :")
  studentsByCity.collect().foreach { case (city, count) => println(s"$city : $count") }

  // 5. Trouver l'étudiant le plus jeune
  val youngestStudent = studentDataRDD.min()(Ordering.by(_.age))
  println(s"\nL'étudiant le plus jeune : $youngestStudent")

  // Fermeture de la session Spark
  spark.stop()


}
