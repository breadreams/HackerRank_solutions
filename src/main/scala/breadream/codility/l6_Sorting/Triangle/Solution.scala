package breadream.codility.l6_Sorting.Triangle

/**
  * An array A consisting of N integers is given.
  * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
  *
  * A[P] + A[Q] > A[R],
  * A[Q] + A[R] > A[P],
  * A[R] + A[P] > A[Q].
  */
object Solution {
  def solution(a: Array[Int]): Int = {
    // N is an integer within the range [0..100,000];
    // each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
    // A empty check
    if (a.isEmpty || a.length < 3) return 0
    a.sorted.sliding(3, 1).foreach {
      case Array(p, q, r) =>
        if (p.toLong + q.toLong > r.toLong)
          return 1
    }
    0
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(10,2,5,1,8,20)))
    println(solution(Array(1,1,1,1,8,20)))
    println(solution(Array(1,2,3)))
    println(solution(Array(-3,-2,-4,3,-3, 2,3,4)))
  }
}


