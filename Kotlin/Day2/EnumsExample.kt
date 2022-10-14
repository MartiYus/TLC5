enum class Colour(val r: Int, val g: Int, val b:Int){

    RED(255,0,0),
    ORANGE(255, 165 ,0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    //turn into decimal
    fun rgb()= (r*256+g)*256 +b
}

fun main(args:Array<String>){
    println(Colour.RED.rgb())
    println(Colour.INDIGO.rgb())

    val colour = Colour.BLUE
    val warmth = when(colour){
        Colour.RED, Colour.ORANGE, Colour.YELLOW -> "warm"
        Colour.GREEN -> "neutral"
        Colour.BLUE, Colour.INDIGO, Colour.VIOLET -> "cold"
    }
    println(warmth)

}



