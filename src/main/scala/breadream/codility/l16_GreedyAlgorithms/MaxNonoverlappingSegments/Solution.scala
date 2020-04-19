package breadream.codility.l16_GreedyAlgorithms.MaxNonoverlappingSegments

/**
  * MaxNonoverlappingSegments
  *
  * Find a maximal set of non-overlapping segments.
  * 겹치지 않는 세그먼트의 최대 세트를 찾으십시오.
  *
  * Located on a line are N segments, numbered from 0 to N − 1, whose positions are given in arrays A and B. For each I (0 ≤ I < N) the position of segment I
  * is from A[I] to B[I] (inclusive). The segments are sorted by their ends, which means that B[K] ≤ B[K + 1] for K such that 0 ≤ K < N − 1.
  *
  * 선에 위치하는 N 세그먼트는 0부터 N - 1까지이며,
  * 배열 A와 B에서 위치가 지정된다. 각 I(0 ≤ I < N)에 대해 세그먼트 I의 위치는 A[I]에서 B[I]까지(포함)이다.
  * 세그먼트는 끝에 따라 정렬되며, 이는 K의 경우 B[K] ≤ B[K + 1]가 0 ≤ K < N - 1이 된다는 것을 의미한다.
  *
  * A[0] = 1    B[0] = 5
  * A[1] = 3    B[1] = 6
  * A[2] = 7    B[2] = 8
  * A[3] = 9    B[3] = 9
  * A[4] = 9    B[4] = 10
  *
  * The segments are shown in the figure below.
  *
  *
  * The size of a non-overlapping set containing a maximal number of segments is 3. For example,
  * possible sets are {0, 2, 3}, {0, 2, 4}, {1, 2, 3} or {1, 2, 4}.
  * There is no non-overlapping set with four segments.
  *
  * Write a function:
  */
object Solution extends App {

  def solution(a: Array[Int], b: Array[Int]): Int = {
    val N = a.length
    if (N == 0) return 0
    if (N == 1) return 1

    var result = 1
    var last = b(0)

    for (i <- 1 until N) {
      if (a(i) > last) {
        result += 1
        last = b(i)
      }
    }
    result
  }

  //println(solution(Array(1,3,7,9,9), Array(5,6,8,9,10)))
  println(solution(Array(1,3,7,9,9), Array(5,6,8,9,10)))


}
