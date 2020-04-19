package breadream.codility.l6_Sorting.Distinct

object Solution extends App {
  def solution(a: Array[Int]): Int = {
    a.distinct.length
  }

  println(solution(Array(2,3,1,2,3,1)))
}
