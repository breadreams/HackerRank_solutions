package breadream.codility.l1_iterations.binarygap

import java.util.regex.Pattern

object Solution extends App {
  def solution(n: Int): Int = {
    val gapPattern = "(?!1)(0+)(?=1)".r
    val max = gapPattern.findAllMatchIn(n.toBinaryString).map(_.toString.length) match {
      case a if a.isEmpty => 0
      case a => a.max
    }
    max
  }

  def solution2(n: Int): Int = {
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

  Array(
    2147483647,
    9, // 2
    529, //s
    20,
    1041,
    32
  ).foreach {
    case a =>
      println(solution(a))
      println(solution2(a))
  }
}
