package codility.l4_CountingElements.FrogRiverOne



/**
  *
  */
object Solution {

  def solution(x: Int, a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val arr = Array.fill(x + 1){0L}
    var count = 0
    a.foreach { e =>
      if (e < arr.length) arr(e) += 1
      if (e == x && arr.forall(_ > 0)) {
        println("요깅")
      }
    }




    println(arr.toList)
    0
  }

  def main(args: Array[String]): Unit = {
    println(solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)))
    /**
      * A[0] =
      * A[1] =
      * A[2] =
      * A[3] =
      * A[4] =
      * A[5] =
      * A[6] =
      * A[7] =
      */

  }
}
