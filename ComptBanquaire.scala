class ComptBanquaire (var id:Int, var solde:Int, nom:String, idagence:Int) extends  Compte {
  def afficheInfoCompte()=s"non: $nom , id:$id, solde:$solde, agence:$idagence"

}
