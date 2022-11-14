//type conversion
object ImplicitFunction{
  def main(args: Array[String]): Unit = {
    val x:Int = "Martina"
    print(x)
  }
  implicit def stringToInt(s:String) : Int = s.length
}