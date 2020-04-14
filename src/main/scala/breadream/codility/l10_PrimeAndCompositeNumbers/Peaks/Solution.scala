package breadream.codility.l10_PrimeAndCompositeNumbers.Peaks

import scala.collection.mutable.ListBuffer.empty

/**
  * Peaks
  *
  * Divide an array into the maximum number of same-sized blocks, each of which should contain an index P such that A[P - 1] < A[P] > A[P + 1].
  *
  * A[0] =  1,
  * A[1] =  2,
  * A[2] =  3,
  * A[3] =  4,
  * A[4] =  3,
  * A[5] =  4,
  * A[6] =  1,
  * A[7] =  2,
  * A[8] =  3,
  * A[9] =  4,
  * A[10] = 6,
  * A[11] = 2
  */
object Solution extends App {
  def solution(a: Array[Int]): Int = {
    val n = a.length

    if (n < 3) return 0

    val peaks = scala.collection.mutable.ListBuffer.empty[Int]
    for (i <- 0 until a.length - 2) {
      val (prev, peak, next) = (a(i), a(i + 1), a(i + 2))
      //println(prev, peak, next)
      if (prev < peak && peak > next) {
        peaks.append(i + 1)
      }
    }
    //println(s"peaks=[${peaks.mkString(",")}]")
    if (peaks.isEmpty) return 0

    val factor = scala.collection.mutable.SortedSet.empty[Int]
    Iterator.from(1).
      takeWhile(i => i.toLong * i <= n.toLong).
      filter(i => n % i == 0).
      foreach { i =>
        if (i > peaks.head) factor.add(i)
        if (n / i > peaks.head) factor.add(n / i)
      }
    //println(s"factor=[${factor.mkString(",")}]")

    factor.iterator.filter(k => a.length / k <= peaks.length).foreach { div =>
      //println("-------------------")
      val gap = a.length / div
      //println(s"div=[$div],gap=[$gap], peaks=[${peaks.length}]")

      val range = (0 until gap).map(i => (div * i, div * (i + 1) - 1))
      //range.foreach { _a => println(s"[${_a._1},${_a._2}]") }

      val isAll = range.forall {
        case (start, end) =>
          peaks.exists(p => start <= p && p <= end)
      }
      if (isAll) return range.length
    }
    0
  }

//  println(solution(Array(1)))
  println(solution(Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)))




}




