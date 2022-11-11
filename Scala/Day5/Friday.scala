import java.io.{FileNotFoundException, FileReader, IOException}
import java.nio.file.AccessDeniedException
import scala.io.Source
import scala.util.{Failure, Success, Try}

@throws(classOf[RuntimeException])
def half(n:Int): Int =
  if n%2 == 0 then
    n/2
  else
    throw new RuntimeException("n must be even")

def workWithFile(path:String) ={
//  try
//    for (line <- Source.fromFile(path).getLines){
//      println(line)
//    }
    Try{ Source.fromFile(path).getLines.mkString}

//  catch
//    case ex: FileNotFoundException =>println("Where is the file?")
//    case ex: AccessDeniedException => println("Oh oh")
}



object Friday {
  def main(args: Array[String]): Unit = {

    //println(half(3))

    try
      print(half(3))
    catch
      case ex: RuntimeException => println("Well that didn't go well")
//    println(half(2))

    val result = workWithFile("src/main/scala/files/text.txt")
    result match{
      case Success(value) => println(value)
      case Failure(e) => println(e.getMessage())
    }

  }
}