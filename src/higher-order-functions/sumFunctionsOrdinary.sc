

object sumFunctionsOrdinary {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0
  	else a + sumInts( a + 1, b)               //> sumInts: (a: Int, b: Int)Int
  	
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0
  	else a * a * a + sumCubes(a + 1, b)       //> sumCubes: (a: Int, b: Int)Int
  
  
  /* The sumInts and sumCubes functions are structurally/logically similar
     hence we can generelize using higher order functions */
     
   def sum(f: Int => Int, a: Int, b: Int): Int =
   	if(a > b) 0
   	else f(a) + sum(f, a + 1, b)              //> sum: (f: Int => Int, a: Int, b: Int)Int
   	
   def id(x: Int): Int = x                        //> id: (x: Int)Int
   def cube(x: Int): Int = x * x * x              //> cube: (x: Int)Int
   
   def main(a: Int, b: Int) {
  	println(s"Sum ints $a to $b: " + sumInts(a, b))
  	println(s"Sum cube ints $a to $b: " + sumCubes(a,b))
  	
  	println(s"HOC: Sum ints $a to $b: " + sum(id, a, b))
  	println(s"HOC: Sum cubes $a to $b: " + sum(cube, a, b))
   }                                              //> main: (a: Int, b: Int)Unit
  
   main(1,100)                                    //> Sum ints 1 to 100: 5050
                                                  //| Sum cube ints 1 to 100: 25502500
                                                  //| HOC: Sum ints 1 to 100: 5050
                                                  //| HOC: Sum cubes 1 to 100: 25502500
}