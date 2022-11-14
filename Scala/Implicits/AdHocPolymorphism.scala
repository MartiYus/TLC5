//import AdHocPolymorphism.{Adder, IntAdder, combine}

object AdHocPolymorphism {
  // intro - overloaded methods
  //https://blog.codecentric.de/en/2017/02/ad-hoc-polymorphism-scala-mere-mortals/
  //VERSION 1
  //def combine(x:Int, y:Int) :Int = x+y
  //def combine(x:String, y:String): String = x+y

  // implementation not clear as we need to ensure that A is able to be added
  //def combine[A](x:A ,y:A) : A = ??

  //let's assume we have the following trait
  //to ensure that A is actually able to be added
/*  trait Addable[A]{
    def add(x:A) :A
  }

  //we can use our helper trait in the combine method to help us with implementation
  //we restrict the signature type to ensure the combine method works with Addable
  //def combine[A<:Addable[A]](x:A, y:A):A = x.add(y)

  //now we lost the possibility to combine String and Int since they are in the standard library
  //if only we could somehow convert Int and String to Addable, we could use a view bound
  def combine[A <% Addable[A]](x:A, y:A) : A = x.add(y)

  //let's define the implicit conversions
  implicit def intToAddable(x:Int):Addable[Int] = new Addable[Int]{
    override def add(other:Int) = x+ other
  }

  implicit def stringToAddable(x:String) :Addable[String] = new Addable[String]{
    override def add(other:String) = x + other
  }
  //drawbacks - we need to use implicit conversion even for just one operation
  //binary operation on a single value?
  //view bounds deprecated from scala 2.11
  //at this point you can run VERSION1
  */


  //VERSION 2
  //we declare Adder implementations for Int and String - separate class with binary operation
  trait Adder[A]{
    def add(x:A, b:A) :A
  }

  //we can implement combine to expect an Adder to help with the logic
  //parameter injection
  //def combine[A](x:A, y:A)(adder: Adder[A]):A = adder.add(x,y)


  //type class is a group of classes that satisfy a contract typically defined by a trait
  /*object IntAdder extends Adder[Int] {
    override def add(x:Int, y:Int) = x+y
  }
  val stringAdder = new Adder[String]{
    override def add(x:String, y:String) = x+y
  }*/

  //our combine function will now become
  //combine(1,2)(IntAdder)
  //now run VERSION2


  //VERSION 3 - make it implicit
  //we can make our dependency implicit
  //def combine[A](x:A, y:A)(implicit adder: Adder[A]):A = adder.add(x,y)
  //and redefine our adders
  /*implicit object IntAdder extends Adder[Int] {
    override def add(x:Int, y:Int) = x+y
  }
  implicit val stringAdder = new Adder[String]{
    override def add(x:String, y:String) = x+y
  }


  // the overall call will be simpler
  //combine(1,2)
  //combine("Hello", "World")

  //in fact, we can simplify the usage of the implicit parameter by using 'implicitly' function
  //def combine[A](x:A, y:A)(implicit adder:Adder[A]):A = implicitly[Adder[A]].add(x,y)

  //there is obviously some syntactic sugar available - called context bound
  def combine[A:Adder](x:A, y:A):A = implicitly[Adder[A]].add(x,y)
  */
  //at this point we may run VERSION3


  //VERSION 1
  /*
  def main(args: Array[String]): Unit = {
    println( combine(1,2 ))
    println( combine("Hello", " World"))
  }
  */


  //VERSION 2
  /*
  def main(args: Array[String]): Unit = {
    println( combine(1,2)(IntAdder) )
    println( combine("Hello", " World")(stringAdder))
  }
  */

  //VERSION3
  /*def main(args: Array[String]): Unit = {

    println( combine(1,2) )
    println( combine("Hello", " World"))
  }*/
}
