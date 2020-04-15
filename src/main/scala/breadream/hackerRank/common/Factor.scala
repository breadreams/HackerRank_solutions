package breadream.hackerRank.common


object Factor extends App {

  def solution(n: Int): Int = {
    val N = n.toLong

    var count = 0
    var i = 1L
    while (i * i < N) {
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

  def factorPairIter(n: Int): Iterator[(Int, Int)] = {
    Iterator.from(1).
      takeWhile(i => i.toLong * i <= n.toLong).
      filter(i => n % i == 0).
      map(i => (i, n / i))
  }


  def rangePrime(n: Int): Seq[Int] = {
    (1 to n).filter(x => !(2 until x - 1).exists(y => x % y == 0) && x > 1)
  }

  def rangeSemiPrime(n: Int): Seq[Int] = {
    val primes = (1 to n / 2).filter(x => !(2 until x - 1).exists(y => x % y == 0) && x > 1)
    var _temp = scala.collection.mutable.SortedSet[Int]()
    primes.view.zipWithIndex.foreach {
      case (x, i) =>
        _temp ++= primes.drop(i).iterator.takeWhile(y => x * y <= n).map(y => x * y)
    }
    _temp.toSeq
  }

  println(factorPairIter(16).toList)
  println(factorPairIter(1).toList)
  println(factorPairIter(16).toList)
  println(factorPairIter(2147483647).toList)
  println(factorPairIter(2147483646).toList)

  println(rangePrime(26))
  println(rangeSemiPrime(26))



  //  def foo(x: Int, a: Int): List[Int] = {
  //    (a * a < x, x % a) match {
  //      case (true, 0) if a != 1 => a :: foo(x / a, a)
  //      case (true, _) => foo(x, a + 1)
  //      case (false, _) => List(x)
  //    }
  //  }
  //  foo(10, 1)


}
