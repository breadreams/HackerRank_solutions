package breadream.codility.l10_PrimeAndCompositeNumbers.CountFactors

object Solution extends App {
  def solution(n: Int): Int = {
    val N = n.toLong
    var count = 0
    var i = 1L
    while (i * i < N) {
      //println(i, n % i)
      if (N % i == 0) {
        //println(s"[$i,${N / i}]")
        count += 2
      }
      i += 1
    }
    if (i * i == N) {
      //println(s"[$i,$i]")
      count += 1
    }
    count
  }

  def solution2(n: Int): Int = {
    def factorPairIter(n: Int): Iterator[(Int, Int)] = {
      Iterator.from(1).
        takeWhile(i => i.toLong * i <= n.toLong).
        filter(i => n % i == 0).
        map(i => (i, n / i))
    }
    var count = 0
    factorPairIter(n).foreach {
      case (a, b) if a == b =>
        count += 1
      case (a, b) =>
        count += 2
    }
    count
  }

  println(solution2(1))
  println(solution2(16))
  println(solution2(10))
  println(solution2(2147483647))
  println(solution2(2147483646))
  println(solution2(9))

  println("=============")

  println(solution(1))
  println(solution(16))
  println(solution(10))
  println(solution(2147483647))
  println(solution(2147483646))
  println(solution(9))

}
