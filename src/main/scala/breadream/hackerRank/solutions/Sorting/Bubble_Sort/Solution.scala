package breadream.hackerRank.solutions.Sorting.Bubble_Sort

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
  * @see [[https://www.hackerrank.com/challenges/ctci-bubble-sort/problem]]
  */
object Solution {

    def bubbleSort(q: Array[Int]): Long = {
        import scala.util.control.Breaks._
        var swapCount: Long = 0
        breakable {
            while(true) {
                var isSwap = false
                q.indices.dropRight(1).foreach { j =>
                    if (q(j) > q(j + 1)) {
                        val n = q(j); q(j) = q(j + 1); q(j + 1) = n; swapCount += 1
                        isSwap = true
                    }
                }
                if (!isSwap) break
            }
        }
        swapCount
    }

    // Complete the countSwaps function below.
    def countSwaps(a: Array[Int]) {
        val swapCount = bubbleSort(a)
        println(s"Array is sorted in $swapCount swaps.\nFirst Element: ${a.head}\nLast Element: ${a.last}")
    }

    def main(args: Array[String]): Unit = {
        val arguments = Array(
            ("1 2 3".split(" ").map(_.toInt)) // Array is sorted in 0 swaps.\nFirst Element: 1\nLast Element: 3
            , ("3 2 1".split(" ").map(_.toInt)) // Array is sorted in 3 swaps.\nFirst Element: 1\nLast Element: 3
        )
        arguments.foreach {
            case (a1) =>
                countSwaps(a1)
        }
    }

    /*
    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val a = stdin.readLine.split(" ").map(_.trim.toInt)
        countSwaps(a)
    }
    */
}

