package breadream.codility.l4_CountingElements.FrogRiverOne

/**
  * FrogRiverOne
  *
  * Find the earliest time when a frog can jump to the other side of a river.
  *
  * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
  *
  * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
  *
  * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
  *
  * For example, you are given integer X = 5 and array A such that:
  *
  * A[0] = 1
  * A[1] = 3
  * A[2] = 1
  * A[3] = 4
  * A[4] = 2
  * A[5] = 3
  * A[6] = 5
  * A[7] = 4
  * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
  *
  * Write a function:
  *
  * class Solution { public int solution(int X, int[] A); }
  *
  * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
  *
  * If the frog is never able to jump to the other side of the river, the function should return −1.
  *
  * For example, given X = 5 and array A such that:
  *
  * A[0] = 1
  * A[1] = 3
  * A[2] = 1
  * A[3] = 4
  * A[4] = 2
  * A[5] = 3
  * A[6] = 5
  * A[7] = 4
  * the function should return 6, as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N and X are integers within the range [1..100,000];
  * each element of array A is an integer within the range [1..X].
  *
  * 개구리가 (현위치) 0 -> X+1 (강건너) 로 넘어가려고 한다.
  * Array A에는 나뭇잎이 도착하는 시간을 나타낸다. 모두 채워지면 개구리는 넘어갈수 있다.
  * 즉, A[0] ~ A[X] 까지 다 체워지는 시간을 구하는 문제
  *
  *
  */
object Solution extends App {

  def solution(x: Int, a: Array[Int]): Int = {
    val temp = Array.fill(x + 1) {
      0L
    }
    var count = 0
    var result = -1
    for ((e, i) <- a.zipWithIndex) {
      if (temp(e) == 0) count += 1
      temp(e) += 1
      if (count == x) {
        result = i
        return result
      }
    }
    result
  }

  println(solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4))) // 6
}
