package hackerRank.solutions.DictionariesAndHashmaps.Sherlock_and_Anagrams

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
  * @see [[https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem]]
  */
object Solution {

  // Complete the sherlockAndAnagrams function below.
  def sherlockAndAnagrams(s: String): Int = {
    // 1 ~ str.length -1 만큼 사이즈로 sliding 해서 모든 조합을 만든다
    (1 until s.length).map { size =>
      s.sliding(size, 1).
          map(str => (str.sorted, str)).toList.
          groupBy(_._1).mapValues(v => (v.length - 1 to 1 by -1).sum).values.sum
    }.sum
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      "abba" // 4
      , "abcd" // 0
      , "ifailuhkqq" // 3
      , "kkkk" // 10
      , "cdcd" // 5
    )
    arguments.foreach {
      case (a1) =>
        val rst = sherlockAndAnagrams(a1)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = stdin.readLine

      val result = sherlockAndAnagrams(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
  */
}

