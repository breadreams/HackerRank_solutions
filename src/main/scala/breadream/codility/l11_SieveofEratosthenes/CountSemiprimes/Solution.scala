package breadream.codility.l11_SieveofEratosthenes.CountSemiprimes

import scala.collection.mutable.Map.empty

/**
  * CountSemiprimes
  *
  * Count the semiprime numbers in the given range [a..b]
  *
  * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
  *
  * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
  *
  * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
  *
  * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
  *
  * For example, consider an integer N = 26 and arrays P, Q such that:
  *
  * P[0] = 1    Q[0] = 26
  * P[1] = 4    Q[1] = 10
  * P[2] = 16   Q[2] = 20
  * The number of semiprimes within each of these ranges is as follows:
  *
  * (1, 26) is 10,
  * (4, 10) is 4,
  * (16, 20) is 0.
  * Write a function:
  *
  * object Solution { def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] }
  *
  * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
  *
  * For example, given an integer N = 26 and arrays P, Q such that:
  *
  * P[0] = 1    Q[0] = 26
  * P[1] = 4    Q[1] = 10
  * P[2] = 16   Q[2] = 20
  * the function should return the values [10, 4, 0], as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [1..50,000];
  * M is an integer within the range [1..30,000];
  * each element of arrays P, Q is an integer within the range [1..N];
  * P[i] ≤ Q[i].
  *
  *
  * O(N * log(log(N)) + M)
  *
  */
object Solution extends App {
  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {
    val primes = (1 to n / 2).filter(x => !(2 until x - 1).exists(y => x % y == 0) && x > 1)
    val semiPrimes = {
      var _temp = scala.collection.mutable.HashSet[Int]()
      primes.view.zipWithIndex.foreach {
        case (x, i) =>
          _temp ++= primes.drop(i).iterator.takeWhile(y => x * y <= n).map(y => x * y)
      }
      _temp
    }
    val spCountArr = Array.fill(n + 1){0}
    semiPrimes.foreach(sp => spCountArr(sp) += 1)
    val spSumArr = spCountArr.scanLeft(0){(acc, e) => acc + e}.drop(1)

    p.iterator.zip(q.iterator).map {
      case (from, to) => spSumArr(to) - spSumArr(from - 1)
    }.toArray
  }
  println(s"result=[${solution(26, Array(1,4,16), Array(26,10,20)).mkString(",")}]")

  /**
    *
    * 4 => 1, 2, 2, 4
    * 6 => 1, 2, 3, 6
    * 21 => 1, 3, 7 21
    * 26 => 1, 2, 13, 26
    *
    *
    *
    *
    *
    */





}

object Semiprime extends App {

  def isSP(n: Int): Boolean = {
    var nf: Int = 0
    var l = n
    for (i <- 2 to l/2) {
      while (l % i == 0) {
        if (nf == 2) return false
        nf +=1
        l /= i
      }
    }
    nf == 2
  }

  (2 to 26) filter {isSP(_) == true} foreach {i => print("%d ".format(i))}
//  println
//  1675 to 1681 foreach {i => println(i+" -> "+isSP(i))}
}


