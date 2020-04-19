package breadream.codility.l15_CaterpillarMethod

object Caterpillar extends App {

  def caterpillarMethod(a: Array[Int], s: Int): Boolean = {
    val n = a.length
    var (front, total) = (0, 0)
    for (back <- a.indices) {
      while (front < n && total + a(front) <= s) {
        total += a(front)
        front += 1
      }
      if (total == s) return true
      total -= a(back)
    }
    false
  }

  def triangles(a: Array[Int]): Int = {
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
    count
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
            if (!(a(x) + a(y) > a(z))) break
//            println(s"x[$x],y[$y],z[$z]")
            z += 1
          }
        }
        println(s"x[$x],y[$y],z[${z-1}] => hit(${z - y - 1})")
        println(z - y - 1)
        result += z - y - 1
      }
    }
    result
  }

//  println(caterpillarMethod(Array(6, 2, 7, 4, 1, 3, 6), 10))
  println(triangles(Array(6, 2, 7, 4, 1, 3, 6)))
  println(trianglesTest(Array(6, 2, 7, 4, 1, 3, 6)))
}
