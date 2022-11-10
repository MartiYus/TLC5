//Liskov Substitution Principle:
// It is safe to assume that a type T is a subtype of a type U if you can
// substitute a value of type T wherever a value of type U is required


import scala.language.postfixOps

class Fruit(val name: String){
  override def toString = name
}

class Banana(n: String) extends Fruit(n)
class Apple(n: String) extends Fruit(n)

class Bag[+A](val things :Seq[A]){

  //contravariant position (-)
  def add[B >: A](item : B) = {
     new Bag[B](things :+ item)
  }

  //covariant position (+)
  def get = things.head

  def printContent = {
    for (i <- things) println(i)
  }
}

object Thursday {

  def main(args:Array[String]) ={
    val fruits : Bag[Fruit] = Bag(Seq(new Fruit("Random Fruit 1"),new Fruit("Random Fruit2"), new Banana("Yellow")) )
    //fruits.printContent
    //println(fruits.get toString )


    val apples : Bag[Apple] = Bag(Seq(new Apple("Pink Lady"), new Apple("Royal Gala") ))
    //apples.add( new Apple("Cooking Apple"))
    //apples.printContent


    //invariance
    val apps : Bag[Fruit] = apples


    //covariance
    val apps2 : Bag[Apple] = apples
    val newBag:Bag[Fruit] = apps2.add(new Fruit("Generic Fruit"))
    newBag.printContent

    //contravariance
    //val apps3: Bag[Apple] = fruits


  }
}
