package breadream.codility.l2_Arrays.OddOccurrencesInArray


/**
  * OddOccurrencesInArray
  *
  * Find value that occurs in odd number of elements.
  *
  * element 중 홀수개 있는 원소를 찾아라
  */
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    val map = scala.collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    a.foreach { i =>
      if (map(i) == 1) {
        map.remove(i)
      } else {
        map(i) += 1
      }
    }
    map.keys.head
  }

  println(solution(Array(3, 6, 3, 6, 9))) // [9, 7, 6, 3, 8]
}
