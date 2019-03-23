

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
   
   def productInts(a: Int, b: Int): Int =
     if (a > b) 1
     else a * productInts(a + 1, b)               //> productInts: (a: Int, b: Int)Int
    
   def productCubes(a: Int, b: Int): Int =
     if (a > b) 1
     else a * a * a * productCubes(a + 1, b)      //> productCubes: (a: Int, b: Int)Int
   
   def main(a: Int, b: Int) {
  	println(s"Sum ints $a to $b: " + sumInts(a, b))
  	println(s"Sum cube ints $a to $b: " + sumCubes(a,b))
  	
  	println(s"HOF: Sum ints $a to $b: " + sum(id, a, b))
  	println(s"HOF: Sum cubes $a to $b: " + sum(cube, a, b))
  	
  	println(s"Product ints $a to $b: " + productInts(a,b))
  	println(s"Product cubes $a to $b: " + productCubes(a, b))
   }                                              //> main: (a: Int, b: Int)Unit
  
   main(1,10)                                     //> Sum ints 1 to 10: 55
                                                  //| Sum cube ints 1 to 10: 3025
                                                  //| HOF: Sum ints 1 to 10: 55
                                                  //| HOF: Sum cubes 1 to 10: 3025
                                                  //| Product ints 1 to 10: 3628800
                                                  //| Product cubes 1 to 10: 520093696
}