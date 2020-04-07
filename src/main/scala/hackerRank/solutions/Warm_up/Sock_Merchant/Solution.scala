package hackerRank.solutions.Warm_up.Sock_Merchant

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
  * @see [[https://www.hackerrank.com/challenges/sock-merchant/problem]]
  */
object Solution {

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    ar.groupBy(a => a).map(_._2.length / 2).sum
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      (9, "10 20 20 10 10 30 50 10 20".split(" ").map(_.toInt)) // 3
      , (10, "1 1 3 1 2 1 3 3 3 3".split(" ").map(_.toInt)) // 4
    )
    arguments.foreach {
      case (n, ar) =>
        val rst = sockMerchant(n, ar)
        println(rst)
    }
  }
  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = sockMerchant(n, ar)

    printWriter.println(result)

    printWriter.close()
  }
  */
}
