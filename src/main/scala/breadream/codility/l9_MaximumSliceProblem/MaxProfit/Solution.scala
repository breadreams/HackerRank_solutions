package breadream.codility.l9_MaximumSliceProblem.MaxProfit

/**
  * MaxProfit
  *
  * Given a log of stock prices compute the maximum possible earning.
  */
object Solution extends App {

  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    var minPrice = a(0)
    var global = 0
    var local = 0
    for (i <- a.indices.drop(1)) {
      local = a(i) - minPrice
      if (a(i) < minPrice) {
        minPrice = a(i)
      }
      global = math.max(local, global)
    }
    if (global < 0) return 0
    global
  }

  println(solution(Array(23171, 21011, 21123, 21366, 21013, 21367)))
//  println(solution(Array(5, 4, 3, 2, 1)))
//  println(solution(Array(8, 9, 3, 6, 1, 2)))


}
