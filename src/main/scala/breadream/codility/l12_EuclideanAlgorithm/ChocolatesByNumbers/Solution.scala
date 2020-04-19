package breadream.codility.l12_EuclideanAlgorithm.ChocolatesByNumbers

/**
  * ChocolatesByNumbers
  *
  * There are N chocolates in a circle. Count the number of chocolates you will eat.
  *
  *
  * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
  *
  *
  */
object Solution extends App {

  def solution2(n: Int, m: Int): Int = {
    def getGCD(x: Int, y: Int): Int = if (y == 0) x else getGCD(y, x % y)
    val gcd = if (n > m) getGCD(n, m) else getGCD(m, n)
    n / gcd
  }

  def solution(n: Int, m: Int): Int = {
    def factor(n: Int): List[Int] = {
      Iterator.from(1).
        takeWhile(i => i.toLong * i <= n.toLong).
        filter(i => n % i == 0).
        flatMap(i => List(i, n / i)).toList
    }
    val factorN = factor(n)
    val factorM = factor(m)
    val commonFactor = factorN.intersect(factorM)
    n / commonFactor.max
  }

  println(solution(10, 4)) // 5
  println(solution(15, 3)) // 5
  println(solution(10, 10)) //
  println(solution(10, 20))
  //println(solution(947853, 4453))
}

