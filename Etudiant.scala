class Etudiant ( nom:String, age:Int,  university:String) extends  Person(nom, age)
{
  override def presentation() =s"${super.presentation} and i comme from  univerty of $university"

  override def manger()=s"${super.manger} des plat a deux euro"

}
