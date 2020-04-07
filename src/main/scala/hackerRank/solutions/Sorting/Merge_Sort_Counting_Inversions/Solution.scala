package hackerRank.solutions.Sorting.Merge_Sort_Counting_Inversions

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
  * @see [[https://www.hackerrank.com/challenges/ctci-merge-sort/problem]]
  */
object Solution {

    import scala.List

    var count = 0

    // 7, 9, 1, 2 => 4
    // 1, 9 ,7, 2
    // 1, 7, 9, 2
    // 1, 7, 9, 2


    // 4, 6, 3, 6 => 3

    def mergeSort(xs: List[Int]): List[Int] = {
        val n = xs.length / 2
        if (n == 0) {
            xs
        } else {
            def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
                case (Nil, y) => y
                case (x, Nil) => x
                case (x :: xs1, y :: ys1) =>
                    if (x < y) {
                        x :: merge(xs1, ys)
                    } else {
                        count += 1
                        y :: merge(xs, ys1)
                    }
            }
            val (left, right) = xs.splitAt(n)
            merge(mergeSort(left), mergeSort(right))
        }
    }

    // Complete the countInversions function below.
    def countInversions(arr: Array[Int]): Long = {

        val list = arr.toList
        println(list)
        val result = mergeSort(list)
        println(result)
        println(s"count => $count")

//        import scala.util.control.Breaks._
//        var tempArr = arr.sliding(2, 2).map {
//            case Array(a, b) if b > a => Array(b, a)
//            case a => a
//        }
//        breakable {
//            while (true) {
//                if (tempArr.length == 1) break
//                tempArr.sliding(2, 2).map {
//                    case Seq(a, b) =>
//
//
//                }
//                tempArr = tempArr.sliding(2, 2).map {
//                    case Seq(a, b) if b > a => Array(b, a)
//                    case Seq(a: Array[Int], b: Array[Int]) if b > a => Array(b, a)
//                    case a => a
//                }
//            }
//        }


        0
    }

    def main(args: Array[String]): Unit = {
        val arguments = Array(
            "1 1 1 2 2".split(" ").map(_.toInt) // 0
            , "2 1 3 1 2".split(" ").map(_.toInt) // 4
        )
        arguments.foreach {
            case (a1) =>
                val rst = countInversions(a1)
                println(rst)
        }
    }

    /*
    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = stdin.readLine.trim.toInt

            val arr = stdin.readLine.split(" ").map(_.trim.toInt)
            val result = countInversions(arr)

            printWriter.println(result)
        }

        printWriter.close()
    }
    */
}

