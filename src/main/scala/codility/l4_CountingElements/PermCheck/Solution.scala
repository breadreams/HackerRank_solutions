package codility.l4_CountingElements.PermCheck

/**
  * PermCheck
  *
  * Check whether array A is a permutation.
  *
  * A non-empty array A consisting of N integers is given.
  *
  * A permutation is a sequence containing each element from 1 to N once, and only once.
  *
  * For example, array A such that:
  *
  * A[0] = 4
  * A[1] = 1
  * A[2] = 3
  * A[3] = 2
  * is a permutation, but array A such that:
  *
  * A[0] = 4
  * A[1] = 1
  * A[2] = 3
  * is not a permutation, because value 2 is missing.
  *
  * The goal is to check whether array A is a permutation.
  *
  * Write a function:
  *
  * class Solution { public int solution(int[] A); }
  *
  * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
  *
  * For example, given array A such that:
  *
  * A[0] = 4
  * A[1] = 1
  * A[2] = 3
  * A[3] = 2
  * the function should return 1.
  *
  * Given array A such that:
  *
  * A[0] = 4
  * A[1] = 1
  * A[2] = 3
  * the function should return 0.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [1..100,000];
  * each element of array A is an integer within the range [1..1,000,000,000].
  */
object Solution {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0

    import scala.util.control.Breaks._
    import scala.collection.mutable.Map.empty

    val tempMap = empty[Int, Int].withDefaultValue(0)
    var wrongFlag = false
    var max = 0
    breakable {
      for (e <- a) {
        max = math.max(e, max)
        tempMap(e) += 1
        if (tempMap(e) > 1) {
          wrongFlag = true
          break
        }
      }
      for (i <- 1 to max) {
        if (tempMap.contains(i)) {
          tempMap.remove(i)
        } else {
          wrongFlag = true
          break
        }
      }
    }
    if (wrongFlag) 0  else 1
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1,2,3,4,5,6,7,8,9,10,10)))
    println(solution(Array(4,1,3,2))) // 1
    println(solution(Array(4,1,3))) // 0
    println(solution(Array(2,3))) // 0
    println(solution(Array(1))) // 0
    println(solution(Array(1, 3, 6, 4, 1, 2))) // 0
    println(solution(Array(1, 2, 3))) // 1
    println(solution(Array(-1, -3))) // 0
    println(solution(Array(1))) // 1
    println(solution(Array())) // 0
  }

}
