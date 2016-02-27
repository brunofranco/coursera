package funsets

object WorkSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	def productF(a: Int, acc: Int): Int = {
  		if (a > b) {
  			acc
  		}
  		else {
  			productF(a + 1, f(a) * acc)
  		}
  	}
  	productF(a, 1)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x * x)(3, 4)                       //> res0: Int = 144
  
  def factorial(fact: Int): Int =  {
  
  	product(x => x)(1, fact)
  
  }                                               //> factorial: (fact: Int)Int
  
  factorial(5)                                    //> res1: Int = 120
  
  
  import FunSets._

	def fsq(x: Int) = x*x                     //> fsq: (x: Int)Int
	val element = FunSets.bound+1             //> element  : Int = 1001
	contains(map(singletonSet(element), fsq), fsq(element))
                                                  //> res2: Boolean = false
	
	
	val u = union(singletonSet(1), singletonSet(3));
                                                  //> u  : Int => Boolean = <function1>
       val u1 = union(u, singletonSet(4))         //> u1  : Int => Boolean = <function1>
       val u2 = union(u1, singletonSet(5))        //> u2  : Int => Boolean = <function1>
       val u3 = union(u2, singletonSet(7))        //> u3  : Int => Boolean = <function1>
       val u4 = union(u3, singletonSet(1000))     //> u4  : Int => Boolean = <function1>
       
       val u5 = map(u4, x => (x-1))               //> u5  : Int => Boolean = <function1>
       assert(contains(u4,1), "should contain 1")
       assert(contains(u5,0), "should contain 0")
       assert(contains(u5,2), "should contain 2")
       assert(contains(u5,3), "should contain 3")
       assert(contains(u5,4), "should contain 4")
       assert(contains(u5,6), "should contain 6")
       assert(contains(u5,999), "should contain 999")
       assert(!contains(u5,9990), "should contain 9999")
  
}