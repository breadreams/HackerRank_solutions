package codility.l2_arrays.OddOccurrencesInArray

object Solution {
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    import scala.collection.mutable.Map.empty
    val map = empty[Int, Int].withDefaultValue(0)
    a.foreach { i =>
      if (map(i) == 1) {
        map.remove(i)
      } else {
        map(i) += 1
      }
    }
    map.keys.head
  }

  def main(args: Array[String]): Unit = {
    List(
      (Array(3, 6, 3, 6, 9)) // [9, 7, 6, 3, 8]
    ).foreach {
      case (a1) => println(solution(a1))
    }
  }
}
