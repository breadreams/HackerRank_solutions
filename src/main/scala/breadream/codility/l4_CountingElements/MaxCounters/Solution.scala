package breadream.codility.l4_CountingElements.MaxCounters

/**
  * MaxCounters
  *
  * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
  */
object Solution extends App {

  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val counter = Array.fill(n) {0}
    var max = 0
    var lastMax = 0
    a.foreach { x =>
      if (x == n + 1) {
        lastMax = max
      } else {
        if (counter(x - 1) < lastMax) {
          counter(x - 1) = lastMax
        }
        counter(x - 1) += 1
        max = math.max(counter(x - 1), max)
      }
    }
    counter.map(math.max(lastMax, _))
  }

  println(solution(5, Array(3, 4, 4, 6, 1, 4, 4)).toList) // [3, 2, 2, 4, 2]
}
