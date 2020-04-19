package breadream.codility.l3_TimeComplexity.FrogJmp


/**
  * FrogJmp
  *
  * Count minimal number of jumps from position X to Y.
 */
object Solution extends App {

  def solution(x: Int, y: Int, d: Int): Int = {
    ((y - x) / d.toDouble).ceil.toInt
  }
  println(solution(10, 85, 5))

}
