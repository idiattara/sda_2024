class Salarie (nom:String, age:Int,  salaire:Int,epargne:Int) extends  Person(nom, age)
{

  def argentdispo()=s"La somme dispo est  ${salaire+epargne}"

  override def manger()=s"${super.manger} qui ne depasse pas ${salaire+epargne}"

}
