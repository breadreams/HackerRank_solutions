package breadream.codility.l8_Leader.EquiLeader

object Solution {

  def solution(a: Array[Int]): Int = {
    if (a.length <= 1) return 0

    import scala.collection.mutable.Map.empty
    val m = empty[Int, Int].withDefaultValue(0)
    a.indices.foreach(i => m(a(i)) += 1)

    var reader = 0
    var count = 0
    m.maxBy(_._2) match {
      case (_reader, _count) => reader = _reader; count = _count
    }
    if (a.length / 2.0 > count) return 0

    val histogram = a.scanLeft(0) {
      case (acc, v) if v == reader => acc + 1
      case (acc, _) => acc
    }.drop(1)

    var result = 0
    for (i <- histogram.indices.dropRight(1)) {
      if (histogram(i) > (i + 1) / 2.0 && count - histogram(i) > (a.length - (i + 1)) / 2.0) {
        result += 1
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(4, 3, 4, 4, 4, 2)))
    println(solution(Array(0, 0)))
  }
}


