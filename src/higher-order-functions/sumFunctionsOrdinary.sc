

object sumFunctionsOrdinary {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sumInts(a: Int, b: Int): Int =
  	if (a > b) 0
  	else a + sumInts( a + 1, b)               //> sumInts: (a: Int, b: Int)Int
  	
  def sumCubes(a: Int, b: Int): Int =
  	if (a > b) 0
  	else a * a * a + sumCubes(a + 1, b)       //> sumCubes: (a: Int, b: Int)Int
  
  def main(a: Int, b: Int) {
  	println(s"Sum ints $a to $b: " + sumInts(a, b))
  	println(s"Sum cube ints $a to $b: " + sumCubes(a,b))
  }                                               //> main: (a: Int, b: Int)Unit
  
  main(1,100)                                     //> Sum ints 1 to 100: 5050
                                                  //| Sum cube ints 1 to 100: 25502500
}