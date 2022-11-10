//Liskov Substitution Principle:
// It is safe to assume that a type T is a subtype of a type U if you can
// substitute a value of type T wherever a value of type U is required


import scala.language.postfixOps

class Fruit(val name: String){
  override def toString = name
}

class Banana(n: String) extends Fruit(n)
class Apple(n: String) extends Fruit(n)

class Bag[A](var things :Seq[A]){

  def add(item : A) = {
     things :+ item
  }

  def get = things.head

  def printContent = {
    for (i <- things) println(i)
  }
}

object Thursday {

  def main(args:Array[String]) ={
    val fruits : Bag[Fruit] = Bag(Seq(new Fruit("Random Fruit 1"),new Fruit("Random Fruit2"), new Banana("Yellow")) )
    fruits.printContent
    println(fruits.get toString )


    val apples : Bag[Apple] = Bag(Seq(new Apple("Pink Lady"), new Apple("Royal Gala") ))
    apples.add( new Apple("Cooking Apple"))
    apples.printContent


    //invariance
    val apps : Bag[Fruit] = apples

    //covariance
    //val apps2 : Bag[Fruit] = apples

    //contravariance
    //val apps3: Bag[Apple] = fruits


  }
}
