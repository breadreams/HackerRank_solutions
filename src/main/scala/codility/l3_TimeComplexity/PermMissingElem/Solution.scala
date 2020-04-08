package codility.l3_TimeComplexity.PermMissingElem

/**
  * PermMissingElem
  * Find the missing element in a given permutation.
  */
object Solution {

  def solution(a: Array[Int]): Int = {
    val (min, max, sum) = (1L, a.length + 1L, a.foldLeft(0L)((acc, e) => acc + e))
    ((min + max) * (max - min + 1) / 2 - sum).toInt
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1,2,3,5)))
    println(solution(Array(1,2)))
    println(solution(Array(20, 19, 17, 16, 15, 14,13, 12, 11)))
  }
}
