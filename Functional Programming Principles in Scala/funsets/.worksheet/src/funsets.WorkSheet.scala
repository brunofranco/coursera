package funsets

object WorkSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(209); 
  
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
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(31); val res$0 = 
  
  product(x => x * x)(3, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(78); 
  
  def factorial(fact: Int): Int =  {
  
  	product(x => x)(1, fact)
  
  };System.out.println("""factorial: (fact: Int)Int""");$skip(18); val res$1 = 
  
  factorial(5)
  
  
  import FunSets._;System.out.println("""res1: Int = """ + $show(res$1));$skip(49); 

	def fsq(x: Int) = x*x;System.out.println("""fsq: (x: Int)Int""");$skip(31); 
	val element = FunSets.bound+1;System.out.println("""element  : Int = """ + $show(element ));$skip(57); val res$2 = 
	contains(map(singletonSet(element), fsq), fsq(element));System.out.println("""res2: Boolean = """ + $show(res$2));$skip(54); 
	
	
	val u = union(singletonSet(1), singletonSet(3));System.out.println("""u  : Int => Boolean = """ + $show(u ));$skip(42); ;
       val u1 = union(u, singletonSet(4));System.out.println("""u1  : Int => Boolean = """ + $show(u1 ));$skip(43); 
       val u2 = union(u1, singletonSet(5));System.out.println("""u2  : Int => Boolean = """ + $show(u2 ));$skip(43); 
       val u3 = union(u2, singletonSet(7));System.out.println("""u3  : Int => Boolean = """ + $show(u3 ));$skip(46); 
       val u4 = union(u3, singletonSet(1000));System.out.println("""u4  : Int => Boolean = """ + $show(u4 ));$skip(44); 
       
       val u5 = map(u4, x => (x-1));System.out.println("""u5  : Int => Boolean = """ + $show(u5 ));$skip(50); 
       assert(contains(u4,1), "should contain 1");$skip(50); 
       assert(contains(u5,0), "should contain 0");$skip(50); 
       assert(contains(u5,2), "should contain 2");$skip(50); 
       assert(contains(u5,3), "should contain 3");$skip(50); 
       assert(contains(u5,4), "should contain 4");$skip(50); 
       assert(contains(u5,6), "should contain 6");$skip(54); 
       assert(contains(u5,999), "should contain 999");$skip(57); 
       assert(!contains(u5,9990), "should contain 9999")}
  
}
