package breadream.codility.l8_Leader.Dominator

object Solution {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return -1
    import scala.collection.mutable.Map.empty
    var dominatorValue = 0
    var dominatorIndex = 0
    val tempMap = empty[Int, Int].withDefaultValue(0)

    a.iterator.zipWithIndex.foreach {
      case (v, i) =>
        if (i == 0) {
          tempMap(v) = 1
          dominatorValue = v
          dominatorIndex = i
        } else {
          tempMap(v) += 1
          if (tempMap(v) > tempMap(dominatorValue)) {
            dominatorValue = v
            dominatorIndex = i
          }
        }
    }
    if (tempMap(dominatorValue) > a.length / 2.0) {
      dominatorIndex
    } else {
      -1
    }
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(-1,3,4,2,-1,3,3)))
    println(solution(Array(3,3,3,2,2,2)))
    println(solution(Array()))
  }
}


