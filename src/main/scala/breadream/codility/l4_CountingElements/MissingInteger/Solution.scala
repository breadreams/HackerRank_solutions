package breadream.codility.l4_CountingElements.MissingInteger

/**
  * MissingInteger
  *
  * Find the smallest positive integer that does not occur in a given sequence.
  *
  * This is a demo task.
  *
  * Write a function:
  *
  * object Solution { def solution(a: Array[Int]): Int }
  *
  * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
  *
  * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
  *
  * Given A = [1, 2, 3], the function should return 4.
  *
  * Given A = [−1, −3], the function should return 1.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [1..100,000];
  * each element of array A is an integer within the range [−1,000,000..1,000,000].
  */
object Solution {


  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    import scala.util.control.Breaks._

    val b = a.filter(_ >= 0).sorted
    if (b.isEmpty || b.head > 1) return 1
    var result = 0
    breakable {
      for (i <- b.indices.dropRight(1)) {
        if (b(i + 1) - b(i) > 1) {
          result = b(i) + 1
          break
        }
      }
      result = b.last + 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1, 3, 6, 4, 1, 2))) // 5

    println(solution(Array(1, 2, 3))) // 4
//
    println(solution(Array(-1, -3))) // 1
  }
}
