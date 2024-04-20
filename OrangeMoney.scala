class OrangeMoney (var id:Int, var solde:Int, nomclient:String) extends  Compte {

  def afficheInfoCompte()=s"no:$nomclient, telephone:$id, solde:$solde"

  def changenumber(newnumber:Int):Unit=id=newnumber


}
