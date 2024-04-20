object CompteMain {
  def showid(compte:Compte):String={

    compte match {
      case comptBanquaire: ComptBanquaire=>s"l id de votre compte banque est  ${comptBanquaire.id}"
      case orangeMoney: OrangeMoney=>s" votre telephone est   ${orangeMoney.id}"
      case _ => "Invalid"

    }
  }
  def main(args: Array[String]): Unit = {
    val comptBanquaire=new ComptBanquaire(12, 10000 ,"diop", 15)
    println(showid(comptBanquaire))
    println(comptBanquaire.afficheInfoCompte())
  }
}
