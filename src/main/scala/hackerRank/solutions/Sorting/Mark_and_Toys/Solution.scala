package hackerRank.solutions.Sorting.Mark_and_Toys

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

/**
  * @see [[https://www.hackerrank.com/challenges/mark-and-toys/problem]]
  */
object Solution {

  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {
    import scala.util.control.Breaks._
    var count = 0
    var totalPrice = 0
    println(prices.sorted.toList)
    breakable {
      for (price <- prices.sorted) {
        totalPrice += price
        if (totalPrice >= k) {
          break
        }
        count += 1
        println(totalPrice, count)
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      ("1 12 5 111 200 1000 10".split(" ").map(_.toInt), 50) // 4
    )
    arguments.foreach {
      case (a1, a2) =>
        val rst = maximumToys(a1, a2)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
      val stdin = scala.io.StdIn

      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      val nk = stdin.readLine.split(" ")

      val n = nk(0).trim.toInt

      val k = nk(1).trim.toInt

      val prices = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = maximumToys(prices, k)

      printWriter.println(result)

      printWriter.close()
  }
  */
}

