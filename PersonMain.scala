object PersonMain {
  def main(args: Array[String]): Unit = {
val etudiant=new Etudiant("diop",23,"uvs")
val a=etudiant.manger()
    println(etudiant.presentation())
    println(a)
  }
}
