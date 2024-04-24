package sn.thies.msd.tpblanc

package sn.thies.msd.tpblanc
import scala.io.Source
object Main_Vide {

  def main(args: Array[String]): Unit = {

    /*directives :
      Acune boucle n est  autorisée
      Que  de la programmation fonctionnelle(lamnda expression  et recursivé)

    */

    val path = "C:\\Users\\ibrah\\Downloads\\TP_Blanc_penda\\TP_Blanc\\datamsd.csv"

    /*Question1

    Cette Fonction lit un fichier et retourne un tableau dont chaque element est  une ligne du  fichier
    il faut utiliser scala.io.Source pour lire le fichier  et pas java.io
    Donc faut import scala.io.Source

     */

    def reader(pathfile: String):Array[String]=scala.io.Source.fromFile(path).getLines().toArray



    /* Question2
    cette fonction prend en entré un tableau de  string et retourne  une matrice dont chaque ligne est  un element du tableau

    Exemple arrayToMat(Array("ba#30#non#matam", "diop#29#oui#dakar"), "#")
     => Array(Array(ba, 30, non, matam), Array(diop, 29, oui, dakar))
     */
    def arrayToMat(tab: Array[String], separator: String): Array[Array[String]] =tab.map(e=>e.split(separator))


    /*  Qestion3
             Permet de filtre(supprime)  les lignes qui contiennent  motAfilter dans une matrice
     */
    def myfilter(mat: Array[Array[String]], motAfilter: String): Array[Array[String]] =mat.filter(e=>e.contains(motAfilter)==false)

    /*Question4
      Applique la fonction myfilter pour une list de string  dans une matrice
     */
    def filters(mat: Array[Array[String]], listmotsAfilter: List[String]): Array[Array[String]] = {
      listmotsAfilter match {
        case Nil => mat
        case mot  :: motsRestants => filters(myfilter(mat, mot), motsRestants)
      }
    }


    /*Question 5
   Supprime une colonne
   Attention l'index commence par 0, donc si  numcol=2 => on supprmie la colonne 3

   */
   def dropcol(mat: Array[Array[String]], numcol: Int): Array[Array[String]] = mat.map(e=>e.take(numcol)++e.drop(numcol+1))
    /*Question 6
    Applique la fonction dropcol sur une liste d'index
   */
    def dropcols(mat: Array[Array[String]], listcol: List[Int]): Array[Array[String]] =
      listcol match{
        case Nil=>mat
        case head::Nil=>dropcol(mat,head)
        case head::tail=>dropcols(dropcol(mat,head),tail)
      }


    /*Question 7 rien a faire pour cette fonction
     notre structure : case class Person(age:Int, rattrapage:Int)
     Convertir  Array[Array[String]] en Array[Person]
     En dichotomisant la variable rattrapage yes=1 et non=0
    */
  def observationToPerson(mat: Array[Array[String]]) = mat.map(e => Person(e(0).toInt, if (e(1) == "oui") 1 else 0))



  def testUnitaireQuestion1: Unit = {
    println("************************************************************************************************")
    println("Question1:Lecture du fichier ")
    for (e <- reader(path)) {
      println(e)
    }
  }

  def testUnitaireQuestion2: Unit = {
    println("************************************************************************************************")
    println("Question2")
    for (e <- arrayToMat(reader(path), "#")) {
      print("[")
      for (x <- e)
       print(s"$x ")
      print("]")
      println()
   }
  }

def testUnitaireQuestion3: Unit = {
println("************************************************************************************************")
println("Question3")
for (e <- myfilter(arrayToMat(reader(path), "#"), "dakar")) {
  for (x <- e)
    print(s"$x  ")
  println()
}
}

def testUnitaireQuestion4: Unit = {
println("************************************************************************************************")
println("Question4")
for (e <- filters(arrayToMat(reader(path), "#"), List("dakar", "thies"))) {
  for (x <- e)
    print(s"$x  ")
  println()
}
}

def testUnitaireQuestion5: Unit = {
println("************************************************************************************************")
println("Question5")
for (e <- dropcol(arrayToMat(reader(path), "#"), 2)) {
  for (x <- e)
    print(s"$x  ")
  println()
}
}
def testUnitaireQuestion6: Unit = {
println("************************************************************************************************")

for (e <- dropcols(arrayToMat(reader(path), "#"), List(0,2, 1))) {
  for (x <- e)
    print(s"$x  ")
  println()
}
}

def testUnitaireQuestion5Et6: Unit = {
println("************************************************************************************************")
println("Application filters et drops ")
for (e <- dropcols(filters(arrayToMat(reader(path), "#"), List("dakar", "thies")), List(0, 2))) {
  for (x <- e)
    print(s"$x  ")
  println()
}
}

def testUnitaireQuestion7: Unit = {
println("************************************************************************************************")
println(" Question:Fin ready for ML")
for (e <- observationToPerson(dropcols(filters(arrayToMat(reader(path), "#"), List("kolda", "tamba")), List(0, 2)))) {
  print(s"$e")
  println()
}
}

testUnitaireQuestion1
testUnitaireQuestion2
testUnitaireQuestion3
testUnitaireQuestion4
testUnitaireQuestion5
testUnitaireQuestion6
testUnitaireQuestion5Et6
testUnitaireQuestion7
  
}
}

