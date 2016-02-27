package recfun

import Array._

object worksheet {
  var pascalTriangle = ofDim[Int](11,11)          //> pascalTriangle  : Array[Array[Int]] = Array(Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                                  //| 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 
                                                  //| 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 
                                                  //| 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 
                                                  //| 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 
                                                  //| 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 
                                                  //| 0, 0, 0, 0, 0, 0, 0))
  pascalTriangle(0)(10)                           //> res0: Int = 0
  
  val coins = List(500,5,50,100,20,200,10)        //> coins  : List[Int] = List(500, 5, 50, 100, 20, 200, 10)
  coins.sorted                                    //> res1: List[Int] = List(5, 10, 20, 50, 100, 200, 500)
}