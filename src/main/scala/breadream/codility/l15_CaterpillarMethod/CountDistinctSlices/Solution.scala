package breadream.codility.l15_CaterpillarMethod.CountDistinctSlices

/**
  * CountDistinctSlices
  *
  * Count the number of distinct slices (containing only unique numbers).
  */
object Solution extends App {

  def solution(m: Int, a: Array[Int]): Int = {
    val MAX = 1000000000
    val n = a.length
    val set = new scala.collection.mutable.HashSet[Int]
    var count = 0
    var front = 0
    for (back <- a.indices) {
      while (front < n && !set.contains(a(front))) {
        set.add(a(front))
        front += 1
        count += 1
        if (count >= MAX) return MAX
      }
      set.remove(a(back))
      count += set.size
      if (count >= MAX) return MAX
    }
    count
  }

  println(solution(6, Array(3,4,5,5,2)))
}
