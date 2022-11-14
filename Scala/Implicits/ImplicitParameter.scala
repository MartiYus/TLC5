object ImplicitParameter {
  def main(args: Array[String]): Unit = {
    //must be for the last parameter
    //similar to default parameter but it can be changed
    def add (x:Int)(implicit y:Int) : Int = x+y

    println(add(1)(2))

    implicit var myNum : Int = 4
    println(add(5))

    //change value of the 'default' parameter
    myNum = 7

    println(add(5))

  }
}
