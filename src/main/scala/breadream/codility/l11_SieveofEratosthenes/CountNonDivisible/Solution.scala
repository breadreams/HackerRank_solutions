package breadream.codility.l11_SieveofEratosthenes.CountNonDivisible

/**
  * CountNonDivisible
  *
  * Calculate the number of elements of an array that are not divisors of each element.
  */
object Solution extends App {

  def solution(a: Array[Int]): Array[Int] = {

    import scala.collection.mutable.Map.empty
    val countMap = a.groupBy(identity).mapValues(_.length).withDefaultValue(0)
    val buffer = empty[Int, Int]
    a.map { n =>
      if (buffer.contains(n)) {
        buffer(n)
      } else {
        val factor = Iterator.from(1).takeWhile(i => i.toLong * i <= n.toLong).filter(i => n % i == 0).map(i => (i, n / i))
        var count = 0
        factor.foreach {
          case (left, right) =>
            if (left == right) {
              count += countMap(left)
            } else {
              count += countMap(left)
              count += countMap(right)
            }
            if (left == n || right == n) count -= 1
        }
        val result = a.length - count - 1
        buffer(n) = result
        result
      }
    }
  }

  println(s"[${solution(Array()).mkString(",")}]")
  println(s"[${solution(Array(3, 1, 2, 3)).mkString(",")}]")
  println(s"[${solution(Array(3, 1, 2, 3, 6)).mkString(",")}]")
}


