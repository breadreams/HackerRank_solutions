package breadream.hackerRank.solutions.Warm_up.Jumping_on_the_Clouds

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
  * @see [[https://www.hackerrank.com/challenges/jumping-on-the-clouds]]
  */
object Solution {

  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int]): Int = {
    import scala.annotation.tailrec

    @tailrec
    def _jumpingOnClouds(r: scala.List[Int], result: Int): Int = {
      r match {
        case Nil =>
          result
        case (_: Int) :: (_: Int) :: 0 :: other =>
          _jumpingOnClouds(0 +: other, result + 1)
        case (_: Int) :: 0 :: other =>
          _jumpingOnClouds(0 +: other, result + 1)
        case (_: Int) :: other =>
          _jumpingOnClouds(other, result)
        case _ =>
          println(s"wrong $r")
          result
      }
    }
    _jumpingOnClouds(c.toList, 0)
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      "0 0 1 0 0 1 0".split(" ").map(_.toInt) // 4
      , "0 0 0 1 0 0".split(" ").map(_.toInt) // 3
    )
    arguments.foreach {
      case ar =>
        val rst = jumpingOnClouds(ar)
        println(rst)
    }
  }

  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    printWriter.println(result)

    printWriter.close()
  }
  */
}
