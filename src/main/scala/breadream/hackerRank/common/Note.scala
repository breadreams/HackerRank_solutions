package breadream.hackerRank.common

object Note extends App {

  import scala.util.control.Breaks._

  breakable {
  }

  /*
  def main(args: Array[String]): Unit = {
    println(solution(5, Array(
      3, 4, 4, 6, 1, 4, 4
    )))
  }

  import scala.collection.mutable.Map.empty
  val tempMap = empty[Int, Int].withDefaultValue(0)


  val tempArr = Array.fill(n){0}

  val stack = new scala.collection.mutable.Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop)
  => 2

  val queue = new scala.collection.mutable.Queue[String]
  queue += "a"
  queue ++= List("b", "c")
  println(queue.dequeue)
  => a


  a.groupBy(identity).mapValues(_.length)

  val aaa =  Array(1,2,3)
  //aaa.map(_ => 3)
  aaa.indices.foreach(aaa(_) = 3)
  println(aaa.toList)


  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
  val fibo = fibs.takeWhile(_ <= a.length + 1).toList.reverse

  def fibs(a: Int = 0, b: Int = 1): Stream[Int] = Stream.cons(a, fibs(b, a + b))
  def fibs(a: Int = 1, b: Int = 2): Stream[Int] = Stream.cons(a, fibs(b, a + b))

  def fibonacci(n: Int): Array[Int] = {
    val result = new Array[Int](n + 1)
    result(0) = 1;
    result(1) = 1
    for (i <- 2 to n) {
      result(i) = (result(i-1) + result(i-2)) % (1<<30)
    }
    result
  }


  */

  val a = Array[Int]()
  println(s"A=[${a.mkString(",")}]")

  //  5 5 5 5
  //  1 2 3 4
  //  6 6 6 6

  def factorPairIter(n: Int): Iterator[(Int, Int)] = {
    Iterator.from(1).
      takeWhile(i => i.toLong * i <= n.toLong).
      filter(i => n % i == 0).
      map(i => (i, n / i))
  }

  def minMaxSumAvg(a: Array[Int]): (Int, Int, Int, Double) = {
    if (a.isEmpty) throw new java.lang.UnsupportedOperationException("array is empty")
    val (min, max, sum) = a.foldLeft((a(0), a(0), 0)) {
      case ((_min, _max, _sum), e) => (math.min(_min, e), math.max(_max, e), _sum + e)
    }
    (min, max, sum, sum / a.length.toDouble)
  }
}
