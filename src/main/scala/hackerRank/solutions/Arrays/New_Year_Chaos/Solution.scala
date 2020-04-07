package hackerRank.solutions.Arrays.New_Year_Chaos

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
  * @see [[https://www.hackerrank.com/challenges/new-year-chaos/problem]]
  */
object Solution {

  def bubbleSort(q: Array[Int]): Int = {
    import scala.util.control.Breaks._
    var swapCount = 0
    breakable {
      while(true) {
        var isSwap = false
        q.indices.dropRight(1).foreach { j =>
          if (q(j) - (j + 1) > 2) {
            swapCount = -1; break
          }
          if (q(j) > q(j + 1)) {
            val n = q(j); q(j) = q(j + 1); q(j + 1) = n; swapCount += 1
            isSwap = true
          }
        }
        if (!isSwap) break
      }
    }
    swapCount
  }

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]) {
    bubbleSort(q) match {
      case cnt if cnt > 0 =>
        println(cnt)
      case _ =>
        println("Too chaotic")
    }
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      "2 1 5 3 4".split(" ").map(_.toInt) // 3
      ,"2 5 1 3 4".split(" ").map(_.toInt) // Too chaotic
      ,"5 1 2 3 7 8 6 4".split(" ").map(_.toInt) // Too chaotic
      ,"1 2 5 3 7 8 6 4".split(" ").map(_.toInt) // 7
      ,"1 2 5 3 4 7 8 6".split(" ").map(_.toInt) // 4
    )
    arguments.foreach {
      case (a1) =>
        minimumBribes(a1)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val q = stdin.readLine.split(" ").map(_.trim.toInt)
      minimumBribes(q)
    }
  }
  */
}

