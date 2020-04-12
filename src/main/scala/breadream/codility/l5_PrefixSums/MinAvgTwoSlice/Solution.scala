package breadream.codility.l5_PrefixSums.MinAvgTwoSlice

/**
  * MinAvgTwoSlice
  *
  * Find the minimal average of any slice containing at least two elements.
  *
  * A non-empty array A consisting of N integers is given.
  * A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
  * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
  *
  * For example, array A such that:
  *
  * A[0] = 4
  * A[1] = 2
  * A[2] = 2
  * A[3] = 5
  * A[4] = 1
  * A[5] = 5
  * A[6] = 8
  * contains the following example slices:
  *
  * slice (1, 2), whose average is (2 + 2) / 2 = 2;
  * slice (3, 4), whose average is (5 + 1) / 2 = 3;
  * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
  * The goal is to find the starting position of a slice whose average is minimal.
  *
  * Write a function:
  *
  * object Solution { def solution(a: Array[Int]): Int }
  *
  * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
  *
  * For example, given array A such that:
  *
  * A[0] = 4
  * A[1] = 2
  * A[2] = 2
  * A[3] = 5
  * A[4] = 1
  * A[5] = 5
  * A[6] = 8
  * the function should return 1, as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [2..100,000];
  * each element of array A is an integer within the range [−10,000..10,000].
  */
object Solution {
  def solution(a: Array[Int]): Int = {
    val iterator = a.sliding(2, 1).zipWithIndex ++ a.sliding(3, 1).zipWithIndex
    val (_, minIndex) = iterator.foldLeft((Double.MaxValue, 0)) {
      case ((_minAvg, _minIndex), (_subArray, _cIndex) ) =>
        val _cAvg = _subArray.sum / _subArray.length.toDouble
        if (_minAvg > _cAvg) {
          (_cAvg, _cIndex)
        } else {
          (_minAvg, _minIndex)
        }
    }
    minIndex
  }

  def main(args: Array[String]): Unit = {
//    println(solution(Array(4,2,2,5,1,5,8)))
//    println(solution(Array(4,2,2,5,1,5,2,2,8)))
//    println(solution(Array(4,2,2,5,1,5,2,2,8,1,2)))
    println(solution(Array(-3, -5, -8, -4, -10)))

//    println(List(-8, -4, -10).sum / 3)
//    println(List(-8, -4).sum / 3)
//    println(List(-4, -10).sum / 3)


  }
}


