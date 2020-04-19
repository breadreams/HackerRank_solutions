package breadream.codility.l3_TimeComplexity.TapeEquilibrium

/**
  * Tape Equilibrium
  *
  * Minimize the value | (A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
  *
  * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
  * N 정수로 구성된 비어 있지 않은 배열 A가 주어진다. 배열 A는 테이프의 숫자를 나타낸다.
  *
  * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
  *
  * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
  *
  * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
  *
  * For example, consider array A such that:
  *
  * A[0] = 3
  * A[1] = 1
  * A[2] = 2
  * A[3] = 4
  * A[4] = 3
  * We can split this tape in four places:
  *
  * P = 1, difference = |3 − 10| = 7
  * P = 2, difference = |4 − 9| = 5
  * P = 3, difference = |6 − 7| = 1
  * P = 4, difference = |10 − 3| = 7
  *
  * Write a function:
  *
  * object Solution { def solution(a: Array[Int]): Int }
  *
  * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
  *
  * For example, given:
  *
  * A[0] = 3
  * A[1] = 1
  * A[2] = 2
  * A[3] = 4
  * A[4] = 3
  * the function should return 1, as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [2..100,000];
  * each element of array A is an integer within the range [−1,000..1,000].
  *
  * P가 Array의 index 일떄
  * |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
  * 값이 최소인 값을 구하라
  */
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    val accArr = a.scanLeft(0)((a, b) => a + b).drop(1)
    val sum = accArr.last
    accArr.dropRight(1).map {
      acc => math.abs(acc - (sum - acc))
    }.min
  }

  println(solution(Array(3,1,2,4,3)))
  println(solution(Array()))
  println(solution(Array(-1000, 1000)))
}
