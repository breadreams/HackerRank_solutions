package breadream.codility.l3_TimeComplexity.PermMissingElem

/**
  * PermMissingElem
  *
  * Find the missing element in a given permutation.
  *
  * 주어진 순열에서 빠진 숫자를 찾아라
  * 주의) 범위가 음수가 아니고, Unique 하기 때문에 초기값(min, max) 지정이 가능하다.
  * 이런 환경에서 빠진요소 찾는 방법은 (min + max) * (max - min + 1) / 2 <- 원래 나와야 할 all sum 값
  * 현재 sum 을 빼면 빠진 숫자를 찾을수 있다.
  * assumptions
  * - N은 [0..100,000] 범위 내의 정수다.
  * - A의 요소는 모두 구별된다.
  * - 배열 A의 각 요소는 [1..N + 1]
  *
  *
  * N은 [0..100,000] 범위 내의 정수다.
  * A의 요소는 모두 구별된다.
  * 배열 A의 각 요소는 [1..N + 1]
  */
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    val (min, max, sum) = (1L, a.length + 1L, a.foldLeft(0L)((acc, e) => acc + e))
    ((min + max) * (max - min + 1) / 2 - sum).toInt
  }

  println(solution(Array(1, 2, 3, 5)))
  println(solution(Array(1, 2)))
  println(solution(Array(20, 19, 17, 16, 15, 14, 13, 12, 11)))
}
