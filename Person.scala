class Person(var nom:String, var age:Int){

  def aff()=println(s"il s'appel ${nom} et  il a ${age} ans ")

  def presentation()=s"my name is $nom and i am $age"

  def manger()="je mange"

  final def checkmaturity():Unit={
  if(age>25)  println("je suis mature")
  else println("je ne suis pas mature")

  }
}
