//class declaration with primary constructor, 2 instance attributes - one mutable, one immutable, and getters/setters
class Person( val firstName: String, var age :Int)

fun main(args:Array<String>){
    val p = Person("Martina", 18)
    //firstName getter
    println("Hi, my name is ${p.firstName}")
    //age setter
    p.age = 21
    //age getter
    println("I am ${p.age} years old")

    val e = Employee(1, "IT")
    val e2 = Employee(1, "FIN", 18000.0)
    println("Employee 1 salary ${e.salary}")
    println("Employee 2 salaary ${e2.salary}")

    val receptionist = Employee("Becca", "0783264783")
    receptionist.name = "Smith"
    println(receptionist.name)
}

//properties can have default values
class Employee(val empId : Int, val dept: String, var salary: Double = 15000.0){
    //initializer block intended to be used with the primary constructor
    init{
        salary = if (dept.equals("IT")) salary*1.20 else salary
    }

    var fName: String =""
    var num :String =""
    constructor(name:String, phoneNum: String):this(0, "REC"){
        fName = name
        num = phoneNum
    }

    //custom setter
    var name: String =""
        set(value){ field = fName + value }

}

