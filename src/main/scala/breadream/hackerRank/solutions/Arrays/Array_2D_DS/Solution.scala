package breadream.hackerRank.solutions.Arrays.Array_2D_DS

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
  * @see [[https://www.hackerrank.com/challenges/2d-Arrays/problem]]
  */
object Solution {

  // Complete the hourglassSum function below.
  def hourglassSum(arr: Array[Array[Int]]): Int = {
    (for {
      i <- arr.indices.dropRight(2)
      j <- arr(i).indices.dropRight(2)
    } yield {
      arr(i)(j) + arr(i)(j+1) + arr(i)(j+2) + arr(i+1)(j+1) + arr(i+2)(j) + arr(i+2)(j+1) + arr(i+2)(j+2)
    }).toList.max
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      Array(
        "1 1 1 0 0 0".split(" ").map(_.toInt),
        "0 1 0 0 0 0".split(" ").map(_.toInt),
        "1 1 1 0 0 0".split(" ").map(_.toInt),
        "0 0 2 4 4 0".split(" ").map(_.toInt),
        "0 0 0 2 0 0".split(" ").map(_.toInt),
        "0 0 1 2 4 0".split(" ").map(_.toInt)
      ) // 19
      , Array(
        "1 1 1 0 0 0".split(" ").map(_.toInt),
        "0 1 0 0 0 0".split(" ").map(_.toInt),
        "1 1 1 0 0 0".split(" ").map(_.toInt),
        "0 9 2 -4 -4 0".split(" ").map(_.toInt),
        "0 0 0 -2 0 0".split(" ").map(_.toInt),
        "0 0 -1 -2 -4 0".split(" ").map(_.toInt)
      ) // 13
      , Array(
        "-9 -9 -9 1 1 1".split(" ").map(_.toInt),
        "0 -9 0 4 3 2".split(" ").map(_.toInt),
        "-9 -9 -9 1 2 3".split(" ").map(_.toInt),
        "0 0 8 6 6 0".split(" ").map(_.toInt),
        "0 0 0 -2 0 0".split(" ").map(_.toInt),
        "0 0 1 2 4 0".split(" ").map(_.toInt)
      ) // 28
    )
    arguments.foreach {
      case (a1) =>
        val rst = hourglassSum(a1)
        println(rst)
    }
  }
  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }
  */
}

