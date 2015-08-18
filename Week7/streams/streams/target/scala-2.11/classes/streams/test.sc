package streams

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin                    //> level  : String = ------
                                                  //| --ST--
                                                  //| --oo--
                                                  //| --oo--
                                                  //| ------
           
  val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)
                                                  //> vector  : Vector[Vector[Char]] = Vector(Vector(-, -, -, -, -, -), Vector(-, 
                                                  //| -, S, T, -, -), Vector(-, -, o, o, -, -), Vector(-, -, o, o, -, -), Vector(-
                                                  //| , -, -, -, -, -))
    
   print( vector)                                 //> Vector(Vector(-, -, -, -, -, -), Vector(-, -, S, T, -, -), Vector(-, -, o, o
}