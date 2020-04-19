package breadream.codility.l16_GreedyAlgorithms.TieRopes

/**
  * TieRopes
  *
  * Tie adjacent ropes to achieve the maximum number of ropes of length >= K.
  * 길이 >=K 의 최대 로프 수를 달성하기 위해 인접한 로프를 묶는다.
  *
  * There are N ropes numbered from 0 to N − 1, whose lengths are given in an array A, lying on the floor in a line. For each I (0 ≤ I < N), the length of rope I on the line is A[I].
  * 0부터 N - 1까지 번호가 매겨진 N개의 로프가 있는데, 그 길이는 배열 A로 되어 있고, 바닥에 일렬로 놓여 있다. 각 I(0 ≤ I < N)에 대해, 회선 I의 길이는 A[I]이다.
  *
  * We say that two ropes I and I + 1 are adjacent. Two adjacent ropes can be tied together with a knot, and the length of the tied rope is the sum of lengths of both ropes. The resulting new rope can then be tied again.
  * 우리는 두 개의 밧줄 I과 I + 1이 인접해 있다고 말한다. 인접한 두 개의 밧줄을 매듭으로 묶을 수 있으며, 묶은 밧줄의 길이는 양쪽 밧줄의 길이를 합한 것이다. 그 결과로 나온 새로운 밧줄은 다시 묶일 수 있다.
  *
  * For a given integer K, the goal is to tie the ropes in such a way that the number of ropes whose length is greater than or equal to K is maximal.
  * 주어진 정수 K의 경우, 길이가 K보다 크거나 같은 로프의 수가 최대가 되도록 로프를 묶는 것이 목표다.
  *
  * For example, consider K = 4 and array A such that:
  *
  * A[0] = 1
  * A[1] = 2
  * A[2] = 3
  * A[3] = 4
  * A[4] = 1
  * A[5] = 1
  * A[6] = 3
  * The ropes are shown in the figure below.
  *
  * We can tie:
  *
  * rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
  * rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.
  *
  * After that, there will be three ropes whose lengths are greater than or equal to K = 4. It is not possible to produce four such ropes.
  * 그 후에는 길이가 K = 4보다 크거나 같은 3개의 밧줄이 있을 것이다. 그런 로프를 4개 생산하는 것은 불가능하다.
  *
  * Write a function:
  *
  * that, given an integer K and a non-empty array A of N integers, returns the maximum number of ropes of length greater than or equal to K that can be created.
  * 정수 K와 N 정수의 비어 있지 않은 배열 A가 주어진 경우, 생성할 수 있는 길이보다 크거나 같은 길이의 최대 로프 수를 반환한다.
  *
  * N is an integer within the range [1..100,000];
  * K is an integer within the range [1..1,000,000,000];
  * each element of array A is an integer within the range [1..1,000,000,000].
  */
object Solution extends App {
  def solution(k: Int, a: Array[Int]): Int = {
    var count = 0
    var sum = 0
    for (i <- a.indices) {
      if (a(i) >= k) {
        count += 1
        sum = 0
      } else {
        sum += a(i)
        if (sum >= k) {
          count += 1
          sum = 0
        }
      }
    }
    count
  }
  println(solution(4, Array(1,1,1,2,3,4,1,1,3)))
  println(solution(4, Array(1,2,3,4,1,1,3)))
  println(solution(1, Array(1)))

}


