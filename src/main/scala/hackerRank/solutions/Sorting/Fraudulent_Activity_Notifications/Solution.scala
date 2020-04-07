package hackerRank.solutions.Sorting.Fraudulent_Activity_Notifications

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import hackerRank.common.util.JsonUtil



/**
  * @see [[https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem]]
  */
object Solution {

    // Complete the activityNotifications function below.
    def activityNotifications(expenditure: Array[Int], d: Int): Int = {
        val freq = Array.ofDim[Int](201)
        def inc(delta: Int, i: Int): Unit = { freq(i) = freq(i) + delta }

        val (i1, i2) = if (d % 2 == 1) (d/2, d/2) else (d/2, d/2-1)
        def m_2: Int = {
            val r = freq.tail.scan(freq.head)(_ + _)
            val m1 = r.indexWhere(_ > i1)
            val m2 = r.indexWhere(_ > i2)
            m1 + m2
        }

        expenditure.zipWithIndex.foldLeft(0) {
            case (_, (e, i)) if i < d =>
                inc(+1, e)
                0

            case (result, (e, i)) =>
                val fraud = if (e >= m_2) 1 else 0
                inc(+1, e)
                inc(-1, expenditure(i - d))
                result + fraud
        }
    }

    def main(args: Array[String]): Unit = {
        val arguments = Array(
            ("2 3 4 2 3 6 8 4 5".split(" ").map(_.toInt), 5) // 2
            , ("1 2 3 4 4".split(" ").map(_.toInt), 4) // 0
        )
        arguments.foreach {
            case (a1, a2) =>
                val rst = activityNotifications(a1, a2)
                println(rst)
        }
    }

    /*
    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val nd = stdin.readLine.split(" ")

        val n = nd(0).trim.toInt

        val d = nd(1).trim.toInt

        val expenditure = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = activityNotifications(expenditure, d)

        printWriter.println(result)

        printWriter.close()
    }
    */
}

