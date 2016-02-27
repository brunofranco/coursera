package recfun

import Array._

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 
  var pascalTriangle = ofDim[Int](11,11);System.out.println("""pascalTriangle  : Array[Array[Int]] = """ + $show(pascalTriangle ));$skip(24); val res$0 = 
  pascalTriangle(0)(10);System.out.println("""res0: Int = """ + $show(res$0));$skip(46); 
  
  val coins = List(500,5,50,100,20,200,10);System.out.println("""coins  : List[Int] = """ + $show(coins ));$skip(15); val res$1 = 
  coins.sorted;System.out.println("""res1: List[Int] = """ + $show(res$1))}
}
