

fun main(args: Array<String>):Unit{
    for (ar in args){
        println(ar)
    }
    println("Hello world!")
    //val - value, var - variable
    val a:Int = 9
    //type inference
    var b:Int
    b=10
    val max = if (a>b) a else b
    val sum : Any = if(a>b){
        println(a)
        a+b
    } else{
        println(b)
    }

    // null values now allowed
    var myString :String = "Martina"
    //myString = null
    demo(myString)
    var result = findMax(3,6)
    println(result)

//    for (i in 1..100){
//       println(fizzBuzz(i))
//    }

//    for(i in 100 downTo 1 step 2){
//        println(fizzBuzz(i))
//    }

    println("Hello, my name is $myString")

    ranges()

}

fun demo(name:String?){
    println(name)
}

//expression body
fun findMax(a:Int, b:Int):Int = if (a>b) a else b



fun ranges(){
//    for (i in 1..100){
//        print(fizzBuzz(i))
//    }
//    for(i in 100 downTo 1 step 2){
//        print(fizzBuzz(i))
//    }
//    for (c in 'A'..'F'){
//      print(c)
//    }
//  //check if element is in a range
    var c:Char = readlnOrNull()!!.toCharArray()[0]
    val msg = when(c){
        in 'A'..'Z' , in 'a'..'z' -> "It's a letter!"
        in '0' ..'9' -> "It's a number!"
        else -> "Dunno"
    }
    print(msg)

}

fun fizzBuzz(i:Int) = when{
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}
