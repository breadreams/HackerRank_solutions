package breadream.codility.l5_PrefixSums.PassingCars

/**
  * PassingCars
  *
  * Count the number of passing cars on the road.
  *
  * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
  *
  * Array A contains only 0s and/or 1s:
  *
  * 0 represents a car traveling east,
  * 1 represents a car traveling west.
  * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
  *
  * For example, consider array A such that:
  *
  * A[0] = 0
  * A[1] = 1
  * A[2] = 0
  * A[3] = 1
  * A[4] = 1
  * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
  *
  * Write a function:
  *
  * class Solution { public int solution(int[] A); }
  *
  * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
  *
  * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
  *
  * For example, given:
  *
  * A[0] = 0
  * A[1] = 1
  * A[2] = 0
  * A[3] = 1
  * A[4] = 1
  * the function should return 5, as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [1..100,000];
  * each element of array A is an integer that can have one of the following values: 0, 1.
  *
  * 0,1 로 구성된 Array[Int] A가 주어졌을때
  *
  * 다음 규칙으로
  * 0 은 동쪽으로 1은 서쪽으로 가는 자동차다
  *
  * 교차되는 수를 구하라
  *
  * example) [0,1,1,0,1,1] => (0,1)(0,2)(0,4)(0,5)(3,4)(3,5) => 6
  */
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    val MAX = 1000000000
    var countOne = a.count(_ == 1)
    var result = 0L
    a.foreach {
      case 0 =>
        result += countOne
        if (result > MAX) return -1
      case 1 =>
        countOne -= 1
    }
    result.toInt
  }

  def solution2(a: Array[Int]): Int = {
    var result = 0L
    var countOne = a.count(_ == 1)
    val maxResult = 1000000000

    a.iterator.takeWhile(_ => result <= maxResult).foreach { e =>
      if (e == 0) {
        result += countOne
      } else {
        countOne -= 1
      }
    }
    result.toInt
  }

  def solution3(a: Array[Int]): Int = {
    var result = 0L
    var countOne = a.count(_ == 1)

    import scala.util.control.Breaks._
    breakable {
      for (e <- a) {
        if (e == 0) {
          result += countOne
          if (result > 1000000000) {
            result = -1
            break
          }
        } else {
          countOne -= 1
        }
      }
    }
    result.toInt
  }

  println(solution(Array(0,1,1,0,1,1)))
  println(solution2(Array(0,1,1,0,1,1)))
  println(solution3(Array(0,1,1,0,1,1)))
  
  println(solution(Array(1,1,0,1,1,0,1,1)))
  println(solution2(Array(1,1,0,1,1,0,1,1)))
  println(solution3(Array(1,1,0,1,1,0,1,1)))

}


