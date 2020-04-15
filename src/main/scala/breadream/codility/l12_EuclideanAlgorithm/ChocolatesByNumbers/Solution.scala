package breadream.codility.l12_EuclideanAlgorithm.ChocolatesByNumbers

/**
  * ChocolatesByNumbers
  *
  * There are N chocolates in a circle. Count the number of chocolates you will eat.
  *
  *
  *
  */
object Solution extends App {

  def solution(n: Int, m: Int): Int = {

    def factor(n: Int): List[Int] = {
      Iterator.from(1).
        takeWhile(i => i.toLong * i <= n.toLong).
        filter(i => n % i == 0).
        flatMap(i => List(i, n / i)).toList
    }

    //    import scala.collection.mutable.Map.empty
    //    val buffer = empty[Int, Boolean]
    //
    //    var count = 0

    // 10 4 => 20
    val factorN = factor(n)
    val factorM = factor(m)
    val commonFactor = factorN.intersect(factorM)
    println(s"n($n)=[${factorN.mkString(",")}]")
    println(s"m($m)=[${factorM.mkString(",")}]")
    println(s"commonFactor=[${commonFactor.mkString(",")}]")
    println(s"max=[${commonFactor.max}]")
    n / commonFactor.max

    //    println("diff n - common", factor(n).diff(commonFactor))
    //    println("diff m - common", factor(m).diff(commonFactor))

    //    println(factor(n).intersect(factor(m)) ++ factor(n).diff(commonFactor) ++ factor(m).diff(commonFactor))
    //
    //
    //    var i = 0L
    //    import scala.util.control.Breaks._
    //    breakable {
    //      while (true) {
    //        val index = ((i * m) % n).toInt
    //        if (!buffer.contains(index)) {
    //          buffer(index) = true
    //        }
    //        if (buffer(index)) {
    //          buffer(index) = false
    //          count += 1
    //        } else {
    //          break
    //        }
    //        i += 1
    //      }
    //    }
    //    count
    //  }
  }

  println(solution(10, 4)) // 5
  println(solution(15, 3)) // 5
  println(solution(10, 10)) //
  println(solution(10, 20))
  //println(solution(947853, 4453))
}

