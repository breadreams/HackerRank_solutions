package breadream.codility.l2_Arrays.CyclicRotation

/**
  * CyclicRotation
  *
  * Rotate an array to the right by a given number of steps.
  *
  * 지정된 단계 수만큼 배열을 오른쪽으로 회전하십시오.
  */
object Solution extends App {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.isEmpty) {
      a
    } else {
      (0 until k).foldLeft(a.toList) {
        case (acc, _) => acc.last +: acc.dropRight(1)
      }.toArray
    }
  }

  println(solution(Array(3, 8, 9, 7, 6), 3).toList)
  println(solution(Array(0, 0, 0), 1).toList)
  println(solution(Array(1, 2, 3, 4), 4).toList)

}
