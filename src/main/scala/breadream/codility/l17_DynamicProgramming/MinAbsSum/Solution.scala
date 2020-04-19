package breadream.codility.l17_DynamicProgramming.MinAbsSum

/**
  * MinAbsSum
  *
  * Given array of integers, find the lowest absolute sum of elements.
  *
  * For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
  *
  * 집합 {-1, 1}에서 N 정수의 주어진 배열 A와 N 정수의 시퀀스 S에 대해 다음과 같이 Val(A, S)을 정의한다.
  *
  * val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
  *
  * (Assume that the sum of zero elements equals zero.)
  * (제로 원소의 합이 0이라고 가정한다.)
  *
  * For a given array A, we are looking for such a sequence S that minimizes val(A,S).
  * 주어진 어레이 A에 대해서는 Val(A,S)을 최소화하는 그런 시퀀스 S를 찾고 있다.
  *
  * that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.
  * N 정수의 배열 A가 주어진 경우, 집합 {-1, 1.}에서 N 정수의 가능한 모든 시퀀스 S에 대해 가능한 모든 val(A,S) 값에서 val(A,S)의 최소값을 계산한다.
  *
  *
  * A[0] =  1
  * A[1] =  5
  * A[2] =  2
  * A[3] = -2
  *
  * your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
  * S = [-1, 1, -1, 1], val(A, S) = 0인 경우 최소 가능한 값이므로 함수는 0을 반환해야 한다.
  *
  * A = [1, 5, 2, -2]
  * S = [−1, 1, −1, 1]
  *
  * N is an integer within the range [0..20,000];
  * each element of array A is an integer within the range [−100..100].
  */
object Solution extends App {
  def solution(a: Array[Int]): Int = {

    if (a.isEmpty) return 0
    if (a.length == 1) return math.abs(a(0))

    val A = a.map(math.abs).sortWith((a, b) => a > b)
    //println(A.mkString(","))
    val sumA = {
      var sum = A.head
      A.drop(1).foreach { e =>
        //println(s"sum=[${sum}], e=[${e}]")
        sum = math.abs(sum -  e)
      }
      //println(sum)
      sum
    }
    //println("sumA", sumA)

    val sumB = {
      val maxSum = A.sum
      import scala.util.control.Breaks._
      var tempSum = 0
      var tempIndex = -1
      breakable {
        //axSum /2
        A.zipWithIndex.foreach {
          case (v , index) =>
            tempSum += v
            tempIndex = index
            if (tempSum == maxSum / 2) {
              break
            }
            if (tempSum > maxSum / 2) {
              tempSum -= v
              break
            }
        }
      }
      math.abs(maxSum - (tempSum * 2))
    }
    //println("sumB", sumB)

    math.min(sumA, sumB)
  }


  println(solution(Array(1,5,2,-2)))
//  println(solution(Array(3, 3, 3, 4, 5)))

//  println(solution((2 until 20).toArray))


//  Array((1,2),(3, 4), (-1, -2), (-3, -4), (3, -4)).foreach {
//    case (a , b) =>
//      println(math.abs(math.abs(a) - math.abs(b)))
//  }



}
