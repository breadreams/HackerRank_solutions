package breadream.codility.l15_CaterpillarMethod.CountTriangles

import scala.collection.mutable

/**
  * CountTriangles
  *
  * Count the number of triangles that can be built from a given set of edges.
  * 주어진 가장자리 집합에서 빌드할 수 있는 삼각형의 수를 세십시오.
  *
  * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
  * N 정수로 구성된 배열 A가 주어진다. 길이가 A[P], A[Q] 및 A[R]인 삼각형을 만들 수 있는 경우 트리플트(P, Q, R)는 삼각형이다. 즉, 트리플트(P, Q, R)는 0 ≤ P < Q < R < N 및:
  *
  * 0 ≤ P < Q < R < N
  *
  * A[P] + A[Q] > A[R],
  * A[Q] + A[R] > A[P],
  * A[R] + A[P] > A[Q].
  *
  * For example, consider array A such that:
  *
  * A[0] = 10    A[1] = 2    A[2] = 5
  * A[3] = 1     A[4] = 8    A[5] = 12
  *
  * There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
  * 이 배열의 요소로부터 구성될 수 있는 4개의 삼각형 세쌍둥이, 즉 (0, 2, 4), (0, 2, 5), (2, 4, 5)가 있다.
  *
  * N is an integer within the range [0..1,000];
  * each element of array A is an integer within the range [1..1,000,000,000].
  */
object Solution extends App {

  def triangles(b: Array[(Int, Int)]): mutable.ListBuffer[List[(Int, Int)]] = {
    val n = b.length
    val result = new mutable.ListBuffer[List[(Int, Int)]]
    for (x <- b.indices) {
      var z = x + 2
      for (y <- x + 1 until n) {
        while (z < n && b(x)._1 + b(y)._1 > b(z)._1) {
          z += 1
        }
        (y + 1 until z).foreach { _z =>
          result.append(List(b(x), b(y), b(_z)).sortBy(_._2))
        }
      }
    }
    println(result.size)
    result
  }

  def solution(a: Array[Int]): Int = {
    if (a.length < 3) return 0

    val A = a.zipWithIndex.sortBy(_._1)
    println(A.toList)
    println(triangles(A))


    println(A.toList)

    val buffer = new scala.collection.mutable.ListBuffer[(Int, Int, Int)]

    val n = a.length
    var result = 0
    for (x <- a.indices) {
      var z = x + 2
      for (y <- x + 1 until n) {
        while (z < n && a(x) + a(y) > a(z)) {
          z += 1
        }
        result += z - y - 1
      }
    }
    result







    3
  }

  def trianglesTest(a: Array[Int]): Int = {
    val n = a.length
    var result = 0
    for (x <- a.indices) {
      var z = x + 2
      for (y <- x + 1 until n) {
        import scala.util.control.Breaks._
        breakable {
          while (z < n) {
            //println(x, y, z)
            if (!(a(x) + a(y) > a(z))) break
            z += 1
          }
        }
        //println(s"x[$x],y[$y],z[${z}~${z + z - y - 1}] => hit(${z - y - 1})")
        if (z - y - 1 > 0) {
          (y + 1 until z).foreach { _z =>
            println(s"x($x)=[${a(x)}],y($y)=[${a(y)}],z(${_z})=[${a(_z)}]")
          }
        }
        result += z - y - 1
      }
    }
    result
  }

  import scala.collection.mutable



  // (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5) = 4
  println(solution(Array(10,2,5,1,8,12)))
}


