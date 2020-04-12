package breadream.codility.l6_Sorting.Distinct

object Solution {
  def solution(a: Array[Int]): Int = {
    a.distinct.length
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(2,3,1,2,3,1)))
  }
}
