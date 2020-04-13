package breadream.codility.l10_PrimeAndCompositeNumbers.CountFactors

object Solution extends App {
  def solution(n: Int): Int = {
    var count = 0
    val N = n.toLong
    var i = 1L
    while (i * i < N) {
      //println(i, n % i)
      if (N % i == 0) {
        println(s"[$i,${N / i}]")
        count += 2
      }
      i += 1
    }
    if (i * i == N) {
      println(s"[$i,$i]")
      count += 1
    }
    count
  }
  println(solution(1))
  println(solution(16))
//  println(solution(10))
//  println(solution(1))
  println(solution(2147483647))
  println(solution(2147483646))
//  println(solution(9))

}
