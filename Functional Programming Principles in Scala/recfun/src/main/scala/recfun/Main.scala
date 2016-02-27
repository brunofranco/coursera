package recfun
import common._
import Array._

object Main {
	def main(args: Array[String]) {
		println("Pascal's Triangle")
		for (row <- 0 to 10) {
			for (col <- 0 to row)
				print(pascal(col, row) + " ")
				println()
		}
	}

	/**
	 * Exercise 1
	 */ 
	def pascal(c: Int, r: Int): Int = {

			val size = List(c,r).max + 1
					var pascalTriangle = ofDim[Int](size,size)
					for (row <- 0 to r) {
						for (col <- 0 to row)
							pascalCell(col, row)
					}

			def pascalCell(c: Int, r: Int): Int = {
					(c, r) match {
					case (0, 0) => {
						pascalTriangle(0)(0) = 1
								1
					}
					case (0, _) => {
						pascalTriangle(0)(r) = 1
								1
					}
					case(_,_) => {
						val value = pascalTriangle(c-1)(r-1) + pascalTriangle(c)(r-1)
								pascalTriangle(c)(r) = value
								value
					}
					}
			}
			pascalTriangle(c)(r)
	}


	/**
	 * Exercise 2
	 */
	def balance(chars: List[Char]): Boolean = {

			def checkBalance(text: List[Char], balance: Int): Boolean = {

					if (balance < 0) {
						false
					} else {
						if (text.isEmpty) {
							balance match {
							case 0 => true
							case _ => false 
							}
						} else {
							text.head match {
							case '(' => {
								checkBalance(text.tail, balance + 1)
							}
							case ')' => {
								checkBalance(text.tail, balance - 1)
							}
							case _ => checkBalance(text.tail, balance)
							}
						}
					}
			}
			checkBalance(chars, 0)
	}

	/**
	 * Exercise 3
	 */
	def countChange(money: Int, coins: List[Int]): Int = {

			def tryAmount(money: Int, sum: Int, coins: List[Int], seq: String): Int = {

					money match {
					case `sum` => 1
					case x if x > sum => {
						var totalSum = tryAmount(money, sum + coins.head, coins, seq+"|"+coins.head)
								var restCoins = coins.tail
								for (coin <- coins.tail) {
									totalSum += tryAmount(money, sum + coin, restCoins, seq+"|"+coin)
											restCoins = restCoins.tail
								}
						totalSum
					}
					case _ => {
						0
					}
					}	    
			}

			if (coins.isEmpty) {
				0
			} else {
				tryAmount(money, 0, coins.sorted, "")
			}
	}
}
