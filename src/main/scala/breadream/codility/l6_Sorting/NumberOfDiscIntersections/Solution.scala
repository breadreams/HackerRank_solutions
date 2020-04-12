package breadream.codility.l6_Sorting.NumberOfDiscIntersections

/**
  * NumberOfDiscIntersections
  *
  * Compute the number of intersections in a sequence of discs.
  *
  *
  */
object Solution {
  def solution(A: Array[Int]): Int = {
    // N = range[0..100,000];
    // A[0..2,147,483,647]
    val N = A.length
    val arr = for (i <- 0 until N) yield {
      (-1 * A(i) + i * 1L, A(i) + i * 1L)
    }
    //println(s"[${arr.mkString(",")}]")
    val sortedArr = arr.sortBy(_._1)
    //println(s"[${sortedArr.mkString(",")}]")

    import scala.util.control.Breaks._
    var count = 0L
    for (i <- sortedArr.indices) {
      breakable {
        for (j <- i + 1 until sortedArr.length) {
          val _a = sortedArr(i)
          val _b = sortedArr(j)
          if (_a._2 < _b._1) {
            //println(s"a[${_a}], b[${_b}] => break!")
            break
          } else if (_a._1 <= _b._1 && _a._2 >= _b._1) {
            count += 1
            //println(s"a[${_a}], b[${_b}] => count++")
          } else {
            //println(s"a[${_a}], b[${_b}] => pass")
          }
        }
      }
    }
    if (count > 10000000) {
      -1
    } else {
      count.toInt
    }
  }

  def main(args: Array[String]): Unit = {
//    println(solution(Array(1,5,2,1,4,0)))
//    println(solution(Array(1, 1, 1)))
    println(solution(Array(1, 2147483647, 0)))
  }
}


