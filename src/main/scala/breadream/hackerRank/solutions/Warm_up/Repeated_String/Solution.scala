package breadream.hackerRank.solutions.Warm_up.Repeated_String

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
  * @see [[https://www.hackerrank.com/challenges/repeated-string/problem]]
  */
object Solution {

  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val repeat = n / s.length
    val rest = n % s.length
    val aCount = s.filter(_ == 'a').length * repeat
    aCount + s.substring(0, rest.toInt).filter(_ == 'a').length
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      ("abc", 10L) // 7
      , ("a", 1000000000000L) // 1000000000000
    )
    arguments.foreach {
      case (a1, a2) =>
        val rst = repeatedString(a1, a2)
        println(rst)
    }
  }
  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    printWriter.println(result)

    printWriter.close()
  }
  */
}

