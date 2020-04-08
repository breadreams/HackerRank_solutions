package codility.l2_arrays.CyclicRotation

import scala.collection.JavaConverters._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.isEmpty) {
      a
    } else {
      (0 until k).foldLeft(a.toList) {
        case (acc, _) => acc.last +: acc.dropRight(1)
      }.toArray
    }
  }

  def main(args: Array[String]): Unit = {
    List(
      (Array(3, 8, 9, 7, 6), 3) // [9, 7, 6, 3, 8]
      ,(Array(0, 0, 0), 1) // [0, 0, 0]
      ,(Array(1, 2, 3, 4), 4) // [1, 2, 3, 4]
    ).foreach {
      case (a1, a2) => println(solution(a1, a2).toList)
    }
  }
}
