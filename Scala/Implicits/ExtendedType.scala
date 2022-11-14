//implicit conversion "pimp my library"
import IntSquare.intToIntSquare

object ExtendedType {
  def main(args: Array[String]): Unit = {
    val a = 4
    //IntSquare needed to be imported here
    println( a.square )
  }


}

class IntSquare(val i: Int) extends AnyVal{
  def square: Int = i*i
}
object IntSquare {
  implicit def intToIntSquare (n: Int): IntSquare = new IntSquare(n)
}
