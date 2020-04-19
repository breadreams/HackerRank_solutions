package breadream.codility.l6_Sorting.Triangle

/**
  * An array A consisting of N integers is given.
  * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
  *
  * A[P] + A[Q] > A[R],
  * A[Q] + A[R] > A[P],
  * A[R] + A[P] > A[Q].
  */
object Solution extends App {
  def solution(a: Array[Int]): Int = {
    // N is an integer within the range [0..100,000];
    // each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
    // A empty check
    if (a.isEmpty || a.length < 3) return 0
    a.sorted.sliding(3, 1).foreach {
      case Array(p, q, r) =>
        if (p.toLong + q.toLong > r.toLong)
          return 1
    }
    0
  }

  def solution2(b: Array[Int]): Int = {
    val a = b.sorted
    val n = a.length
    var count = 0
    for (x <- a.indices) {
      var z = x + 2
      for (y <- x + 1 until n) {
        while (z < n && a(x) + a(y) > a(z)) {
          z += 1
        }
        count += z - y - 1
      }
    }
    if (count > 0) 1 else 0
  }

  def solution3(b: Array[Int]): Int = {
    val a = b.sorted
    val n = a.length
    var result = 0
    for (x <- a.indices) {
      var z = x + 2
      for (y <- x + 1 until n) {
        import scala.util.control.Breaks._
        breakable {
          while (z < n) {
            if (!(a(x) + a(y) > a(z))) break
            //            println(s"x[$x],y[$y],z[$z]")
            z += 1
          }
        }
        println(s"x[$x],y[$y],z[${z-1}] => hit(${z - y - 1})")
        //println(z - y - 1)
        result += z - y - 1
      }
    }
    result
  }

//  println(solution(Array(10,2,5,1,8,20)))
//  println(solution(Array(1,1,1,1,8,20)))
//  println(solution(Array(1,2,3)))
//  println(solution(Array(-3,-2,-4,3,-3, 2,3,4)))

  println

//  println(solution3(Array(10,2,5,1,8,20)))
//  println(solution3(Array(1,1,1,1,8,20)))
//  println(solution3(Array(1,2,3)))
  println(solution3(Array(-3,-2,-4,3,-3, 2,3,4)))


}


