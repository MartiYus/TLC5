//Type conversion
object ImplicitClass {
  def main(args: Array[String]): Unit = {
    val name = "Martina"
    name.describe()
  }
  // if we call a method on an object and the method is not defined in the object's class -> the
  // compiler will look for a class with 1 parameter that matches the object's type and that defines
  // the required method
  implicit class ImprovedString(s:String){
    def describe()= println(s"$s is  ${s.length} characters long")
  }

}


