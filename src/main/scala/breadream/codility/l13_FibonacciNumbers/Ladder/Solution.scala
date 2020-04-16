package breadream.codility.l13_FibonacciNumbers.Ladder

/**
  * Ladder
  *
  * Count the number of different ways of climbing to the top of a ladder.
  * 사다리의 꼭대기까지 오르는 다양한 방법의 수를 세어 보라.
  *
  * You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:
  * 사다리를 올라가야 한다. 사다리는 1부터 N까지 번호가 매겨진 정확히 N개의 렁을 가지고 있다. 한 걸음 한 걸음이면 한두 릉씩 올라갈 수 있다. 보다 정확하게:
  *
  * - with your first step you can stand on rung 1 or 2
  * 너의 첫걸음이 1번 또는 2번 릉에 서있을 수 있다.,
  * - if you are on rung K, you can move to rungs K + 1 or K + 2,
  * 만약 당신이 Rung K에 있다면, 당신은 Rungs K + 1 또는 K + 2로 이동할 수 있다.
  * - finally you have to stand on rung N.
  * 마침내 너는 N위에 서야 한다.
  *
  * Your task is to count the number of different ways of climbing to the top of the ladder.
  * 당신의 임무는 사다리의 꼭대기에 오르는 다양한 방법의 수를 세는 것이다.
  *
  * For example, given N = 4, you have five different ways of climbing, ascending by:
  *
  * 1, 1, 1 and 1 rung,
  * 1, 1 and 2 rungs,
  * 1, 2 and 1 rung,
  * 2, 1 and 1 rungs, and
  * 2 and 2 rungs.
  *
  * Given N = 5, you have eight different ways of climbing, ascending by:
  *
  * 1, 1, 1, 1 and 1 rung,
  * 1, 1, 1 and 2 rungs,
  * 1, 1, 2 and 1 rung,
  * 1, 2, 1 and 1 rung,
  * 1, 2 and 2 rungs,
  * 2, 1, 1 and 1 rungs,
  * 2, 1 and 2 rungs, and
  * 2, 2 and 1 rung.
  *
  * The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.
  * 다른 방법의 수는 매우 클 수 있으므로 주어진 정수 P에 대해 결과 모둘로 2P를 반환해도 충분하다.
  *
  * that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].
  * L 정수의 비어 있지 않은 배열 A와 B가 주어진 경우, 연속 답을 지정하는 L 정수로 구성된 배열을 반환한다. 위치 I는 A[I] rungs modulo 2B[I]로 사다리를 오르는 다양한 방법을 포함해야 한다.
  *
  * For example, given L = 5 and:
  *
  * A[0] = 4   B[0] = 3
  * A[1] = 4   B[1] = 2
  * A[2] = 5   B[2] = 4
  * A[3] = 5   B[3] = 3
  * A[4] = 1   B[4] = 1
  *
  * the function should return the sequence [5, 1, 8, 0, 1], as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * L is an integer within the range [1..50,000];
  * each element of array A is an integer within the range [1..L];
  * each element of array B is an integer within the range [1..30].
  *
  *
  * 1 => [1] => 1
  * 2 => [1,1] => 2
  * 3 => [1,1,1] [1,2] [2,1]=> 3
  * 4 => [1,1,1,1] [1,1,2] [1,2,1] [2,1,1] [2,2] = 5
  *
  */
object Solution extends App {



  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
    val max = 1 << 30 // B Max
    def fibonacci(n: Int): Array[Int] = {
      val result = new Array[Int](n + 1)
      result(0) = 1
      result(1) = 1
      for (i <- 2 to n) {
        result(i) = (result(i - 1) + result(i - 2)) % max
      }
      result
    }
    val fibo = fibonacci(a.length + 1)
    //println(fibo.toList)
    a.zip(b).map { case (n, m) => fibo(n) % (1 << m) }
  }

  println(solution(Array(4, 4, 5, 5, 1), Array(3, 2, 4, 3, 1)).toList) // 5, 1, 8, 0, 1
}


