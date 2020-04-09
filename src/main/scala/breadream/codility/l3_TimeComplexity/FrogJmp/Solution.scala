package breadream.codility.l3_TimeComplexity.FrogJmp


/**
  * FrogJmp
  * Count minimal number of jumps from position X to Y.
 */
object Solution {

  def solution(x: Int, y: Int, d: Int): Int = {
    // write your code in Scala 2.12
//    y - x match {
//      case a if a % d == 0 => a / d
//      case a => a / d + 1
//    }
    ((y - x) / d) + (if ((y - x) % d == 0) 0 else 1)
  }

  def main(args: Array[String]): Unit = {
    //println(solution(10, 85, 30))
    println(solution(10, 85, 5))
  }

}
