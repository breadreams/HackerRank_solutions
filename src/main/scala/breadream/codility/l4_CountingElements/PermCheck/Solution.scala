package breadream.codility.l4_CountingElements.PermCheck

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
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    val buffer = scala.collection.mutable.SortedSet.empty[Int]
    var sum = 0L
    a.iterator.foreach { e =>
      if (buffer.contains(e)) return 0
      buffer.add(e)
      sum += e
    }
    if (buffer.size == 1) {
      if (buffer.head == 1) return 1 else return 0
    }
    val (min, max) = (1, buffer.last)
    if ((min + max) * (max - min + 1) / 2 - sum == 0) 1 else 0
  }

  def solution2(a: Array[Int]): Int = {
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

  println

  println(solution2(Array(1,2,3,4,5,6,7,8,9,10,10)))
  println(solution2(Array(4,1,3,2))) // 1
  println(solution2(Array(4,1,3))) // 0
  println(solution2(Array(2,3))) // 0
  println(solution2(Array(1))) // 0
  println(solution2(Array(1, 3, 6, 4, 1, 2))) // 0
  println(solution2(Array(1, 2, 3))) // 1
  println(solution2(Array(-1, -3))) // 0
  println(solution2(Array(1))) // 1
  println(solution2(Array())) // 0

//  0 0
//  1 1
//  0 0
//  0 0
//  1 1
//  0 0
//  1 1
//  1 0
//  1 1
//  0 0

}
