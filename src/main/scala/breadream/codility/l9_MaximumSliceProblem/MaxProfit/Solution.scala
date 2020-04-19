package breadream.codility.l9_MaximumSliceProblem.MaxProfit

/**
  * MaxProfit
  *
  * Given a log of stock prices compute the maximum possible earning.
  */
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    var maxEarning = 0
    var minPrice = a(0)
    for (i <- a.indices.drop(1)) {
      val earning = a(i) - minPrice
      minPrice = math.min(a(i), minPrice)
      maxEarning = math.max(earning, maxEarning)
    }
    if (maxEarning < 0) return 0
    maxEarning
  }

  println(solution(Array(23171, 21011, 21123, 21366, 21013, 21367)))
//  println(solution(Array(5, 4, 3, 2, 1)))
//  println(solution(Array(8, 9, 3, 6, 1, 2)))


}
