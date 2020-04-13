package breadream.codility.l9_MaximumSliceProblem.MaxSliceSum

/**
  * MaxSliceSum
  *
  * Find a maximum sum of a compact subsequence of array elements.
  *
  * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
  *
  *
  *
  *
  */
object Solution extends App {
  def solution(a: Array[Int]): Int = {

    if (a.length == 1) return a(0)

    var local = a(0)
    var global = a(0)
    for (i <- 1 until a.length) {
      //println(s"a($i)=[${a(i)}], local=[${local}], global=[$global]")
      local = math.max(a(i), a(i) + local)
      global = math.max(global, local)
    }
    global
  }

  println(solution(Array(3,2,-6,4,0)))
  println(solution(Array(3,2,-6,4,0,7,9,-19)))

}
