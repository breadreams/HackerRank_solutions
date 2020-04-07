package hackerRank.solutions.DictionariesAndHashmaps.Two_Strings

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
  * @see [[https://www.hackerrank.com/challenges/two-strings/problem]]
  */
object Solution {

  // Complete the twoStrings function below.
  def twoStrings(s1: String, s2: String): String = {
    val m1 = s1.groupBy(a => a).map(t => t._1 -> t._2.length)
    val m2 = s2.groupBy(a => a).map(t => t._1 -> t._2.length)
    m1.keys.find(char => m2.contains(char)) match {
      case Some(_) =>
        "YES"
      case None =>
        "NO"
    }
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      ("hello", "world") // YES
      , ("hi","world") // NO
      , ("aardvark", "apple") // YES
      , ("beetroot", "sandals") // NO
    )
    arguments.foreach {
      case (a1, a2) =>
        val rst = twoStrings(a1, a2)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s1 = stdin.readLine

      val s2 = stdin.readLine

      val result = twoStrings(s1, s2)

      printWriter.println(result)
    }

    printWriter.close()
  }
  */
}

