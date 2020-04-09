package breadream.hackerRank.solutions.Warm_up.Counting_Valleys

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
  * @see [[https://www.hackerrank.com/challenges/counting-valleys/problem]]
  */
object Solution {

  // Complete the countingValleys function below.
  def countingValleys(n: Int, s: String): Int = {
    var count = 0
    s.foldLeft(0) {
      case (level, 'U') =>
        if (level == -1) count = count + 1
        level + 1
      case (level, 'D') =>
        level - 1
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      (8, "UDDDUDUU") // 1
      , (12, "DDUUDDUDUUUD") // 2
    )
    arguments.foreach {
      case (n, ar) =>
        val rst = countingValleys(n, ar)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = countingValleys(n, s)

    printWriter.println(result)

    printWriter.close()
  }
  */
}