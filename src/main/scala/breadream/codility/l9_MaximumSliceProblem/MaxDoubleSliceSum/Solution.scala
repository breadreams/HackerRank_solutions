package breadream.codility.l9_MaximumSliceProblem.MaxDoubleSliceSum

object Solution extends App {

  def solution(a: Array[Int]): Int = {

    val N = a.length

    if (N == 3) return 0

    val headSum = Array.fill[Int](N){0}
    val tailSum = Array.fill[Int](N){0}

    (1 until N -1).foreach { i =>
      headSum(i) = math.max(0, headSum(i - 1) + a(i))
    }
    (N -2 until 0 by -1).foreach { i =>
      tailSum(i) = math.max(0, tailSum(i + 1) + a(i))
    }

    println(s"A=[${a.mkString(",")}]")
    println(s"left=[${tailSum.mkString(",")}] right=[${headSum.mkString(",")}]")

    var maxValue = 0
    (1 until a.length - 1).foreach { i =>
      val right = headSum(i-1)
      val left = tailSum(i+1)
      println(s"$i l=[$left] r=[$right] sum=[${right + left}]")
      maxValue = math.max(maxValue, right + left)
    }
    return maxValue


//    val a2 = a
//    val rightSum = a2.drop(1).scanLeft(0) { case (acc, v) => acc + v }.drop(1)
//    val leftSum = a2.drop(1).scanRight(0) { case (acc, v) => acc + v }.dropRight(1)

//    println(s"A=[${a.mkString(",")}]")
//    println(s"A2=[${a2.mkString(",")}]")
//    println(s"rightSum=[${rightSum.mkString(",")}]")
//    println(s"leftSum=[${leftSum.mkString(",")}]")
//    if (a2.length == 3) return 0

//    var maxValue = 0
//    (1 until a2.length - 1).foreach { i =>
//      val right = if (rightSum(i+1) < 0 ) 0 else rightSum(i+1)
//      val left = if (leftSum(i-1) < 0 ) 0 else leftSum(i-1)
//      println(s"$i l=[${leftSum(i-1)},$left] r=[${rightSum(i+1)},$right] sum=[${rightSum(i+1) + leftSum(i-1)}]")
//      maxValue = math.max(maxValue, right + left)
//    }
//    maxValue

//    for (i <- a2.indices) {
//      val left = leftSum.slice(0, i) match {
//        case _left if _left.isEmpty =>
//          println(s"leftSum  =[${leftSum.mkString(",")} | left  =[]")
//          0
//        case _left =>
//          println(s"leftSum  =[${leftSum.mkString(",")} | left  =[${_left.mkString(",")}]")
//          _left.max - leftSum(i)
//      }
//      val right = rightSum.slice(i + 1, rightSum.length) match {
//        case _right if _right.isEmpty =>
//          println(s"rightSum =[${rightSum.mkString(",")} | right =[]")
//          0
//        case _right =>
//          println(s"rightSum =[${rightSum.mkString(",")} | right =[${_right.mkString(",")}]")
//          _right.max - rightSum(i)
//      }
//      println(left, right, left + right)
//      maxValue = math.max(left + right, maxValue)
//    }
//    maxValue
  }
  println(solution(Array(3,2,6,-1,4,5,-1,0)))
//  println(solution(Array(3,2,6,-1,4,5,-1,2)))
//  println(solution(Array(5, 17, 0, 3)))
//  println(solution(Array(0, 10, -5, -2, 0)))
}
