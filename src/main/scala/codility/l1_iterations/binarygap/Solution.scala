package codility.l1_iterations.binarygap

import java.util.regex.Pattern

object Solution {
    def solution(n: Int): Int = {
        val gapPattern = "(?!1)(0+)(?=1)".r
        val max = gapPattern.findAllMatchIn(n.toBinaryString).map(_.toString.length) match {
            case a if a.isEmpty => 0
            case a => a.max
        }
        max
    }

    def main(args: Array[String]): Unit = {
        List(
            2147483647,
            9, // 2
            529, //s
            20,
            1041,
            32
        ).foreach {
            case a => solution(a)
        }
    }
}
