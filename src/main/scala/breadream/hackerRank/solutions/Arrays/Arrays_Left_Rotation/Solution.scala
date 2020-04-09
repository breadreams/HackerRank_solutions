package breadream.hackerRank.solutions.Arrays.Arrays_Left_Rotation

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
  * @see [[https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem]]
  */
object Solution {

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    (0 until d).foreach{ j =>
      val head = a.head
      a.indices.dropRight(1).foreach { i =>
        a(i) = a(i + 1)
      }
      a(a.length -1) = head
    }
    a
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      ("1 2 3 4 5".split(" ").map(_.trim.toInt), 4) // 5 1 2 3 4
      , ("41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51".split(" ").map(_.trim.toInt), 10) // 77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77
    )
    arguments.foreach {
      case (a1, a2) =>
        val rst = rotLeft(a1, a2)
        println(rst.mkString(","))
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nd = stdin.readLine.split(" ")

    val n = nd(0).trim.toInt

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
  */
}

