package streams

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(109); 
  val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin;System.out.println("""level  : String = """ + $show(level ));$skip(111); 
           
  val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*);System.out.println("""vector  : Vector[Vector[Char]] = """ + $show(vector ));$skip(23); 
    
   print( vector)}
}
