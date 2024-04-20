abstract  class Compte {
  var id:Int
  var solde:Int
  def retirer(somme:Int):Unit={
    solde=solde-somme
  }
  def depot(somme:Int):Unit={
    solde=solde+somme
  }
  def afficheInfoCompte():String


}
