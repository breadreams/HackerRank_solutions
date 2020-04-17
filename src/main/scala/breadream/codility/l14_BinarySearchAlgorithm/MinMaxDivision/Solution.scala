package breadream.codility.l14_BinarySearchAlgorithm.MinMaxDivision

/**
  * MinMaxDivision
  *
  * Divide array A into K blocks and minimize the largest sum of any block.
  *
  * You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.
  *
  * 정수 K, M 및 N 정수로 구성된 비어 있지 않은 배열 A가 주어진다. 배열의 모든 요소는 M보다 크지 않다.
  *
  *
  * You should divide this array into K blocks of consecutive elements.
  * 이 배열을 연속 원소의 K 블럭으로 나누어야 한다.
  *
  * The size of the block is any integer between 0 and N. Every element of the array should belong to some block.
  *
  */
object Solution extends App {

  def check(mid: Int, k: Int, a: Array[Int]): Boolean = {
    var block = k
    var tempSum = 0
    a.foreach { e =>
      tempSum += e
      if (tempSum > mid) {
        block -= 1
        tempSum = e
      }
      if (block == 0) return false
    }
    true
  }

  def solution(k: Int, m: Int, a: Array[Int]): Int = {
    var (min, max) = (a.max, a.sum)
    var result = 0
    while (min <= max) {
      val mid = (max + min) / 2
      if (check(mid, k, a)) {
        result = mid
        max = mid - 1
      } else {
        min = mid + 1
      }
    }
    result
  }

  println(solution(3, 5, Array(2, 1, 5, 1, 2, 2, 2)))
  println(solution(2, 5, Array(5, 3)))
}


