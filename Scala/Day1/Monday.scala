import scala.language.postfixOps

class Employee( fname:String,  lname:String, flag:Boolean,  private var a:Int = 34 ){

  val name = fname + lname
  println("I'm creating the object!")
  //def this(f:String, l:String) = this(f, l, 34)
  //getter
  def age = a

  //setter
  def age_=(newAge:Int) = if(newAge > 0 && newAge < 50) a = newAge

  def isOlder(otherAge:Integer) = a>otherAge

  def +(newAge : Int) = a + newAge

  def `isOlder:`(otherAge : Integer) = a<otherAge

  def returnName = name

}

object FirstDay {

  def main(args:Array[String]) = {
    println("Hello World!")
    //infix notation

    val p = new Employee("John", "Doe", true, 34)

    val p2 = new Employee("Martina", "Yusuf", false)
//    println(p.name)
//    p.age = 50
//    println(p.age)

    //p.fname = "Martina"
    //println(p.isOlder(18))

    println(p isOlder 18)
    println( 18 `isOlder:` p)
    println(p.returnName)
    println(p.toString())
    //postfix notation
    println( p returnName )
//    p.+(10)
//    p + 10
  }

  def myMax(x:Int, y:Int) = {
    println("I'm doing max")
    if (x>y) x else y
  }

  def sayHello() = println("Hello")

}

//println(2 + 3)
//println( 2.+(3) )
//
//var a = 6; val b = 8
//a = 10
////    val z = a+3
////    println(z)
////
////    println(myMax(3,9))
////
////    sayHello()
//val name = "Martina"
//println(s"Hello $name ${3+7} ")
