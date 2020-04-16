package breadream.codility.l12_EuclideanAlgorithm.CommonPrimeDivisors

/**
  * CommonPrimeDivisors
  *
  * Check whether two numbers have the same prime divisors.
  *
  *
  *
  *
  */
object Solution extends App {


  def solution2(a: Array[Int], b: Array[Int]): Int = {

    def getGCD(x: Int, y: Int): Int = {
      if (y == 0) x else getGCD(y, x % y)
    }

    def hasSamePrimeDiv(x: Int, y:Int): Boolean = {
      var a = if (x > y) x else y
      var b = if (x > y) y else x

      val gcd = getGCD(a, b)
      var gcdA = 0
      var gcdB = 0
      //println(s"gcd($a, $b)=[$gcd]")
      while(gcdA != 1) {
        gcdA = getGCD(a, gcd)
        a = a / gcdA
      }
      while(gcdB != 1) {
        gcdB = getGCD(b, gcd)
        b = b / gcdB
      }
      (a, b) match {
        case (1, 1) => true
        case _ => false
      }
    }
    var count = 0
    for (z <- a.indices) {
      if (hasSamePrimeDiv(a(z), b(z))) {
        count += 1
      }
    }
    count
  }

  def solution(a: Array[Int], b: Array[Int]): Int = {
    import scala.collection.mutable.Map.empty
    val primeTmp = empty[Int, Boolean].withDefaultValue(false)

    def isPrime(x: Int): Boolean = {
      if (primeTmp.contains(x)) {
        primeTmp(x)
      } else {
        val _isPrime = !(2 until x - 1).exists(y => x % y == 0) && x > 1
        primeTmp(x) = _isPrime
        _isPrime
      }
    }

    val factorTmp = empty[Int, Set[Int]]
    def factor(n: Int): Set[Int] = {
      if (factorTmp.contains(n)) {
        factorTmp(n)
      } else {
        val result = Iterator.from(1).
          takeWhile(i => i.toLong * i <= n.toLong).
          filter(i => n % i == 0).
          flatMap(i => List(i, n / i)).filter(isPrime).toSet
        factorTmp(n) = result
        result
      }
    }

    var count = 0
    for (z <- a.indices) {
      (a(z), b(z)) match {
        case(left, right) =>
          val factorA = factor(left)
          val factorB = factor(right)
//          println(s"[${left}], factor=[${factorA.mkString(",")}]")
//          println(s"[${right}], factor=[${factorB.mkString(",")}]")
          if (factorA == factorB) {
            count += 1
          }
      }
    }
    count
  }

//  println(solution(Array(15), Array(75)))
  println(solution2(Array(3), Array(5)))
//  println(solution(Array(15,10,3), Array(75,30,5)))

//  import scala.collection.mutable.ListBuffer.empty
//  val a = empty[Int]
//  val b = empty[Int]
//  (1 to 70).foreach { i =>
//    (1 to 70).foreach { j =>
//      a.append(i); b.append(j)
//    }
//  }
//  println(solution(a.toArray, b.toArray))
//  println(solution2(a.toArray, b.toArray))

}


