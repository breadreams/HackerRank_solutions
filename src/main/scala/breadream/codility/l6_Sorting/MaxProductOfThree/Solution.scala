package breadream.codility.l6_Sorting.MaxProductOfThree

/**
  * MaxProductOfThree
  *
  * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
  *
  *
  *
  *
  */
object Solution {

  def solution(a: Array[Int]): Int = {
    val arr = a.sorted
    val A = arr.takeRight(3).product
    val B = (arr.take(2) ++ arr.takeRight(1)).product
    math.max(A, B)
  }

  def main(args: Array[String]): Unit = {
//    println(solution(Array(-3,1,2,-2,5,6)))
    println(solution(Array(-5, 5, -5, 4)))
  }
}


