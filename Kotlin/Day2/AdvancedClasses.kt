//data class
data class Client(val name:String, val postCode: String)

fun main(args:Array<String>){
    val c1 = Client("Martina", "BN1 0NA")
    val c2 = Client("Martina", "BN1 0NA")
    val c3 = c1.copy();
    //.equals
    println(c1 == c2)
    println(c1)
    println(c2)
    println(c3)

    //destructuring data class
    val (name, postCode) = c1
    println(name)
    println(postCode)

    println("Martina".lastChar())

    val clients = listOf<Client>(c1, c2)
    for (c in clients){
        println(c)
    }

    val clientsMap = mapOf<String, Client>("IT" to c1, "REC" to c2)
    for ((key, value) in clientsMap){
        println("$key -> $value")
    }


}

fun String.lastChar():Char = this.get(this.length - 1)

