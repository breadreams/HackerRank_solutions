package breadream.codility.l4_CountingElements.MaxCounters

/**
  * MaxCounters
  *
  * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
  */
object Solution {

  def solution(n: Int, a: Array[Int]): Array[Int] = {
    // write your code in Scala 2.12
    val temp = Array.fill(n){0}
    var max = 0
    var tempMax = 0
    a.foreach { e =>
      if (e == n + 1) {
        tempMax = max
      } else {
        if (tempMax > temp(e - 1)) {
          temp(e - 1) = tempMax + 1
        } else {
          temp(e - 1) += 1
        }
        max = math.max(max, temp(e - 1))
      }
    }
    temp.indices.foreach(i => if (temp(i) < tempMax) temp(i) = tempMax)
    temp
  }

  def main(args: Array[String]): Unit = {
    println(solution(5, Array(
      3, 4, 4, 6, 1, 4, 4
    )).toList) // [3, 2, 2, 4, 2]
  }
}
