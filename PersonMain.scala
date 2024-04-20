object PersonMain {
  def main(args: Array[String]): Unit = {
    val etudiant=new Etudiant("diop",23,"uvs")
    println(etudiant.presentation())
    println(etudiant.manger())
    etudiant.checkmaturity()
    val sal=new Salarie("fall",34,2000,1200)
    println(sal.presentation())
    println(sal.manger())
    sal.checkmaturity()
  }
}
