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
    maxValue
  }

  println(solution(Array(3,2,6,-1,4,5,-1,0)))
//  println(solution(Array(3,2,6,-1,4,5,-1,2)))
//  println(solution(Array(5, 17, 0, 3)))
//  println(solution(Array(0, 10, -5, -2, 0)))
}
