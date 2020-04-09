package breadream.hackerRank.common

object BubbleSort {

    def swap(q: Array[Int], i:Int, j:Int): Unit = {
        val n = q(j); q(j) = q(i); q(i) = n
    }

    def bubbleSort[T](q: Array[T])(implicit num: Numeric[T]): Unit = {
        import scala.util.control.Breaks._
        import num._
        var swapCount = 0
        breakable {
            while(true) {
                var isSwap = false
                q.indices.dropRight(1).foreach { j =>
                    if (q(j) > q(j + 1)) {
                        val n = q(j); q(j) = q(j + 1); q(j + 1) = n; swapCount += 1
                        isSwap = true
                    }
                }
                if (!isSwap) break
            }
        }
        swapCount
    }

    def bubbleSort(q: Array[Int]): Long = {
        import scala.util.control.Breaks._
        var swapCount: Long = 0
        breakable {
            while(true) {
                var isSwap = false
                q.indices.dropRight(1).foreach { j =>
                    if (q(j) - (j + 1) > 2) {
                        swapCount = -1; break
                    }
                    if (q(j) > q(j + 1)) {
                        val n = q(j); q(j) = q(j + 1); q(j + 1) = n; swapCount += 1
                        isSwap = true
                    }
                }
                if (!isSwap) break
            }
        }
        swapCount
    }
}
