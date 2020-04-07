package hackerRank.solutions.Arrays.Array_Manipulation

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
  * @see [[https://www.hackerrank.com/challenges/crush/problem]]
  */
object Solution {

  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    val psArr = Array.fill(n + 1){0L}
    queries.foreach { arr =>
      val start = arr(0) - 1
      val end = arr(1)
      val value = arr(2)
      psArr(start) += value
      psArr(end) -= value
    }
    var max = 0L
    psArr.foldLeft(0L){ (acc, value) =>
      val sum = acc + value
      max = Math.max(max, sum)
      sum
    }
    max
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      (5, Array(
        "1 2 100".split(" ").map(_.trim.toInt),
        "2 5 100".split(" ").map(_.trim.toInt),
        "3 4 100".split(" ").map(_.trim.toInt)
      )) // 200
      , (10, Array(
        "1 5 3".split(" ").map(_.trim.toInt),
        "4 8 7".split(" ").map(_.trim.toInt),
        "6 9 1".split(" ").map(_.trim.toInt)
      )) // 10
      , (10, Array(
        "2 6 8".split(" ").map(_.trim.toInt),
        "3 5 7".split(" ").map(_.trim.toInt),
        "1 8 1".split(" ").map(_.trim.toInt),
        "5 9 15".split(" ").map(_.trim.toInt)
      )) // 31
    )
    arguments.foreach {
      case (a1, a2) =>
        val rst = arrayManipulation(a1, a2)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val queries = Array.ofDim[Int](m, 3)

    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = arrayManipulation(n, queries)

    printWriter.println(result)

    printWriter.close()
  }
  */
}

