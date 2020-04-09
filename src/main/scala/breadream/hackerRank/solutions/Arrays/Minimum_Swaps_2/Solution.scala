package breadream.hackerRank.solutions.Arrays.Minimum_Swaps_2

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
  * @see [[https://www.hackerrank.com/challenges/minimum-swaps-2/problem]]
  */
object Solution {

  // Complete the minimumSwaps function below.
  def minimumSwaps(arr: Array[Int]): Int = {
    def swap(q: Array[Int], i:Int, j:Int): Unit = {
      val n = q(j); q(j) = q(i); q(i) = n
    }

    import scala.util.control.Breaks._
    var swapCount = 0
    for (i <- arr.indices) {
      if (arr(i) != i + 1) {
        breakable {
          for (j <- i + 1 until arr.length) {
            if (arr(j) == i + 1) {
              swap(arr, j, i); swapCount += 1; break
            }
          }
        }
      }
    }
    swapCount
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      "4 3 1 2".split(" ").map(_.toInt) // 3
      , "2 3 4 1 5".split(" ").map(_.toInt) // 3
      , "1 3 5 2 4 6 7".split(" ").map(_.toInt) // 3
    )
    arguments.foreach {
      case (a1) =>
        val rst = minimumSwaps(a1)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val res = minimumSwaps(arr)

    printWriter.println(res)

    printWriter.close()
  }
  */
}

