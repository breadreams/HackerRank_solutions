package breadream.codility.Demo

object Solution extends App {
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val set = scala.collection.mutable.SortedSet.empty[Int]
    a.foreach(v => if (v > 0) set.add(v))

    if (set.isEmpty || set.head != 1) return 1

    set.iterator.zipWithIndex.foreach {
      case (value, index) =>
        if (value != index + 1) {
          return index + 1
        }
    }
    set.last + 1
  }

  println(solution(Array(1,3,6,4,1,2)))
  println(solution(Array(1,2,3)))
  println(solution(Array(-1, -1)))
}
