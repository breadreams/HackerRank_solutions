package breadream.hackerRank.common

object Note extends App {

  /**
    * collection 선언 함수들 중 자주 사용되는것
    */
  def collectionsExample(): Unit = {

    // 필요시 import 사용
    import scala.collection.mutable

    // array
    val array = Array.fill[Int](10){0}
    // list
    val list = scala.collection.mutable.ListBuffer.empty[Int]
    // map
    val map = scala.collection.mutable.Map.empty[Int, Int].withDefaultValue(0)

    // stack
    val stack = new scala.collection.mutable.Stack[Int]
    stack.push(1)
    println(stack.top)
    println(stack.pop)

    // queue
    val queue = new scala.collection.mutable.Queue[String]
    queue += "a"
    queue ++= List("b", "c")
    println(queue.dequeue)

    // create array to count map
    val countMap = Array(1,2,3,4,5).groupBy(identity).mapValues(_.length)
  }

  /**
    * math 함수들중 유용한것
    */
  def mathExample(): Unit = {
    1.2123141.ceil.toInt // 소수점 올림
    1.2123141.floor.toInt // 소수점 버림
  }

  /**
    * break 사용시 자주 사용됨
    */
  def breakSample(): Unit = {
    import scala.util.control.Breaks._
    breakable {
      break
    }
  }

  /**
    * loop : for while foreach 등 자주 사용됨
    */
  def loopSample(a: Array[Int]): Unit = {

    for (i <- a.indices) {
      val value = a(i)
    }

    var i = 0
    var j = a.length - 1
    while (i < j) {
      i += 1
      return
    }

    a.foreach { v =>

    }
  }

  /**
    * debug용 프린트
    */
  def debug[T](a: Array[T], name: String = "a"): Unit = {
    println(s"$name=[${a.mkString(",")}]")
  }

  /**
    * BinaryGap : Iterator
    *
    * String pattern 찾을때 사용
    * 2진수형 String 문법에서 제일긴 0000...000 을 찾을때 사용
    */
  def binaryGap(n: Int): Int = {
    val str = n.toBinaryString
    val list = "(?!1)(0+)(?=1)".r.findAllMatchIn(str).map(_.toString)
    if (list.nonEmpty) {
      list.map(_.length).max
    } else {
      0
    }
  }

  /**
    * CyclicRotation : Array
    *
    * Array 오른쪽으로 회전
    */
  def rotationArray(a: Array[Int], k: Int): Array[Int] = {
    if (a.isEmpty) {
      a
    } else {
      (0 until k).foldLeft(a.toList) {
        case (acc, _) => acc.last +: acc.dropRight(1)
      }.toArray
    }
  }

  /**
    * 주어진 순열에서 빠진 숫자를 찾아라
    * 주의) 범위가 음수가 아니고, Unique 하기 때문에 초기값(min, max) 지정이 가능하다.
    * 이런 환경에서 빠진요소 찾는 방법은 (min + max) * (max - min + 1) / 2 <- 원래 나와야 할 all sum 값
    * 현재 sum 을 빼면 빠진 숫자를 찾을수 있다.
    *
    * assumptions
    * - N은 [0..100,000] 범위 내의 정수다.
    * - A의 요소는 모두 구별된다.
    * - 배열 A의 각 요소는 [1..N + 1]
    */
  def permMissingElem(a: Array[Int]): Int = {
    if (a.isEmpty) return 0
    val (min, max, sum) = (1L, a.length + 1L, a.foldLeft(0L)((acc, e) => acc + e))
    ((min + max) * (max - min + 1) / 2 - sum).toInt
  }


  /**
    * 피보나치(finonacci) 수열 생성
    * 27이 넘어가면 Int.MAX 넘음
    */
  def fibonacci(n: Int): Array[Int] = {
    val result = new Array[Int](n + 1)
    result(0) = 0
    result(1) = 1
    for (i <- 2 to n) {
      // mod(나머지) 형태가 필요한경우 사용/ Max값이 지정되면 사용해도 되는듯 / Int Max와 연관 있음
//      result(i) = (result(i-1) + result(i-2)) % (1<<30)
      result(i) = result(i-1) + result(i-2)
    }
    result
  }

  /**
    * 삼각형 갯수 구하기
    *
    * a는 sort 되어있어야 함
    *
    * Long 처리가 필요한지 확인이 필요하다 / 양수에서만 가능한듯?
    *
    */
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

  /**
    * Caterpillar Method 애벌래
    *
    * 부분합이 s 이상 되는 모든 count
    *
    */
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

  /**
    * array (min, max, sum) one time
    */
  def minMaxSum(a: Array[Int]): (Int, Int, Long) = {
    if (a.isEmpty) throw new java.lang.UnsupportedOperationException("array is empty")
    a.foldLeft((a(0), a(0), 0L)) {
      case ((_min, _max, _sum), e) => (math.min(_min, e), math.max(_max, e), _sum + e)
    }
  }

  /**
    * 공약수 구하기
    */
  def factorPairIter(n: Int): Iterator[(Int, Int)] = {
    Iterator.from(1).
      takeWhile(i => i.toLong * i <= n.toLong).
      filter(i => n % i == 0).
      map(i => (i, n / i))
  }



}
