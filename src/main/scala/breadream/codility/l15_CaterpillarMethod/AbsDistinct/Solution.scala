package breadream.codility.l15_CaterpillarMethod.AbsDistinct

/**
  * AbsDistinct
  *
  * Compute number of distinct absolute values of sorted array elements.
  */
object Solution extends App {
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val set = new scala.collection.mutable.HashSet[Int]
    a.foreach { e => set.add(math.abs(e)) }
    set.size
  }
  println(solution(Array(-5,3,1,0,3,6)))
}


