package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(countChange(4, Array(1, 2, 3, 4).toList))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def innerBalance(acc: Int, chars: List[Char]): Int = {
      if (chars.isEmpty) acc
      else if (chars.head == '(') innerBalance(acc + 1, chars.tail)
      else if (chars.head == ')')
        if (acc == 0) -1
        else innerBalance(acc - 1, chars.tail)
      else innerBalance(acc, chars.tail)
    }

    innerBalance(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(capacity: Int, changes: List[Int]): Int = {
      if (capacity == 0) 1
      else if (capacity < 0 || changes.isEmpty) 0
      else change(capacity - changes.head, changes) + change(capacity, changes.tail)
    }

    change(money, coins.sorted)
  }
}
