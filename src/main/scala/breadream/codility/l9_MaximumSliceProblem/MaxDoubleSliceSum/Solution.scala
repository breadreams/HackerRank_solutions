package breadream.codility.l9_MaximumSliceProblem.MaxDoubleSliceSum

object Solution extends App {

  def solution(a: Array[Int]): Int = {

    // 3, 2, 6, -1, 4, 5, -1, 2

    // A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

    // 0,3,6 => 2 + 6 + 4 + 5 = 17,

    /**
      * 0,1,2, 3,4,5, 6,7
      * 3,2,6,-1,4,5,-1,2
      *
      *               +1 ~  -1
      * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
      * 1 ~ 5
      * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
      * 1 ~ 6 -3
      * double slice (3, 4, 5), sum is 0.
      * 4 ~ 4
      *
      *
      * 0,1, 2,3,4, 5
      * 2,6,-1,4,5,-1
      *
      */
    val a2 = a.drop(1).dropRight(1)
    val rightSum = a2.scanLeft(0) { case (acc, v) => acc + v }.drop(1)
    val leftSum = a2.scanRight(0) { case (acc, v) => acc + v }.dropRight(1)

    println(s"A=[${a.mkString(",")}]")
    println(s"A2=[${a2.mkString(",")}]")
    println(s"rightSum=[${rightSum.mkString(",")}]")
    println(s"leftSum=[${leftSum.mkString(",")}]")
    if (a2.length == 1) return 0

    var maxValue = 0
    for (i <- a2.indices) {
      val left = leftSum.slice(0, i) match {
        case _left if _left.isEmpty =>
          println(s"leftSum  =[${leftSum.mkString(",")} | left  =[]")
          0
        case _left =>
          println(s"leftSum  =[${leftSum.mkString(",")} | left  =[${_left.mkString(",")}]")
          _left.max - leftSum(i)
      }
      val right = rightSum.slice(i + 1, rightSum.length) match {
        case _right if _right.isEmpty =>
          println(s"rightSum =[${rightSum.mkString(",")} | right =[]")
          0
        case _right =>
          println(s"rightSum =[${rightSum.mkString(",")} | right =[${_right.mkString(",")}]")
          _right.max - rightSum(i)
      }
      println(left, right, left + right)
      maxValue = math.max(left + right, maxValue)
    }
    maxValue
  }
//  println(solution(Array(3,2,6,-1,4,5,-1,2)))
//  println(solution(Array(3,2,6,-1,4,5,-1,2)))
//  println(solution(Array(5, 17, 0, 3)))
  println(solution(Array(0, 10, -5, -2, 0)))
}
