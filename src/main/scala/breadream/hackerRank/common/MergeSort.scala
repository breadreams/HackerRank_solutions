package breadream.hackerRank.common

object MergeSort {

    import scala.List

    def mergeSort(xs: List[Int]): List[Int] = {
        val n = xs.length / 2
        if (n == 0) {
            xs
        } else {
            def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
                case (Nil, y) => y
                case (x, Nil) => x
                case (x :: xs1, y :: ys1) =>
                    if (x < y)
                        x :: merge(xs1, ys)
                    else
                        y :: merge(xs, ys1)
            }
            val (left, right) = xs.splitAt(n)
            merge(mergeSort(left), mergeSort(right))
        }
    }
}
