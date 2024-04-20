object MainOrdinateur {


  val ordi1=new Ordinateur(" HP " ) with Traitement

  def main(args: Array[String]): Unit = {
    val ordi1=new Ordinateur(" HP " ) with Traitement
    println(ordi1.action)
  }
}
