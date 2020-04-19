package breadream.codility.l1_iterations.binarygap

import java.util.regex.Pattern

/**
  * BinaryGap
  *
  * Find longest sequence of zeros in binary representation of an integer.
  * 정수의 이진 표현에서 가장 긴 0의 길이를 찾으세요.
  *
  * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
  *
  * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
  *
  * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
  *
  * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [1..2,147,483,647].
  *
  */
object Solution extends App {

  def solution(n: Int): Int = {
    val str = n.toBinaryString
    val list = "(?!1)(0+)(?=1)".r.findAllMatchIn(str).map(_.toString)
    if (list.nonEmpty) {
      list.map(_.length).max
    } else {
      0
    }
  }

  def solution2(n: Int): Int = {
    val gapPattern = "(?!1)(0+)(?=1)".r
    val max = gapPattern.findAllMatchIn(n.toBinaryString).map(_.toString.length) match {
      case a if a.isEmpty => 0
      case a => a.max
    }
    max
  }

  def solution3(n: Int): Int = {
    val bStr = n.toBinaryString
    var global = 0
    var local = 0
    for (i <- 0 until bStr.length) {
      if (bStr(i) == '1') {
        if (local > 0) {
          global = math.max(global, local)
        }
        local = 0
      } else {
        local += 1
      }
    }
    global
  }

  Array(2147483647, 9, 529, 20, 1041, 32 ).foreach {
    case a =>
      println(solution(a))
      println(solution2(a))
  }
}
