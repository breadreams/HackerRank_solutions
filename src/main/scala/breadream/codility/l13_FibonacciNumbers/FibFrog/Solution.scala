package breadream.codility.l13_FibonacciNumbers.FibFrog

/**
  * FibFrog
  *
  * Count the minimum number of jumps required for a frog to get to the other side of a river.
  *
  * The Fibonacci sequence is defined using the following recursive formula:
  *
  * F(0) = 0
  * F(1) = 1
  * F(M) = F(M - 1) + F(M - 2) if M >= 2
  * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
  *
  * The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
  *
  * 0 represents a position without a leaf;
  * 1 represents a position containing a leaf.
  * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
  *
  * For example, consider array A such that:
  *
  * A[0] = 0
  * A[1] = 0
  * A[2] = 0
  * A[3] = 1
  * A[4] = 1
  * A[5] = 0
  * A[6] = 1
  * A[7] = 0
  * A[8] = 0
  * A[9] = 0
  * A[10] = 0
  * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
  *
  * Write a function:
  *
  * object Solution { def solution(a: Array[Int]): Int }
  *
  * that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
  *
  * For example, given:
  *
  * A[0] = 0
  * A[1] = 0
  * A[2] = 0
  * A[3] = 1
  * A[4] = 1
  * A[5] = 0
  * A[6] = 1
  * A[7] = 0
  * A[8] = 0
  * A[9] = 0
  * A[10] = 0
  * the function should return 3, as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [0..100,000];
  * each element of array A is an integer that can have one of the following values: 0, 1.
  *
  */
object Solution extends App {

  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

  def solution2(a: Array[Int]): Int = {

    //println(s"a=[${a.mkString(",")}]")

    val N = a.length
    if (N == 0) return 1
    val fibo = fibs.takeWhile(_ <= a.length + 1).toList.reverse

    //println(s"fibo=[${fibo.mkString(",")}]")

    val q = new scala.collection.mutable.Queue[(Int, Int)]
    val chk = Array.fill[Boolean](N + 1){false}
    q.enqueue((-1, 0))
    //println(s"queue=[${q}] init")

    while(q.nonEmpty) {
      val current = q.dequeue()
      //println(s"current=[${current}]")
      for (f <- fibo) {
        val next = current._1 + f
        //println(s"fibo=[${f}], next=[${next}]")
        if (next == N) {
          return current._2 + 1
        } else if (next < N && next >= 0) {
          //println(s"a($next)=[${a(next)}], leaf=[${a(next) == 1}], checked=[${chk(next)}]")
          if (a(next) == 1 && !chk(next)) {
            chk(next) = true
            q.enqueue((next, current._2 + 1))
            //println(s"queue=[${q}] enqueue")
          }
        }
      }
    }
    -1
  }

  def solution(a: Array[Int]): Int = {
    import scala.collection.mutable.HashSet

    val fibNums = fibs.takeWhile(_ <= a.length + 1).toList.reverse
    val fibHash = HashSet(fibNums :_*)
    //println(fibNums)

    val leafIndices = ((1, -1) +: a.view.zipWithIndex.filter(p => p._1 == 1) :+ (1, a.length)).map(_._2)
    //println(leafIndices.toList)

    import scala.collection.mutable._
    val buffer = ListMap.empty[Int, ListBuffer[Int]]

    for (i <- leafIndices.indices) {
      val leafA = leafIndices(i)
      val nextList = ListBuffer.empty[Int]
      leafIndices.drop(i + 1).foreach { leafB =>
        if (fibHash.contains(leafB - leafA)) {
          nextList.append(leafB)
        }
      }
      if (nextList.nonEmpty) {
        buffer(leafA) = nextList
      }
    }

    def aaa(index:Int, count: Int) : Int = {
      if (index >= a.length) {
        count
      } else {
        if (buffer.contains(index)) {
          buffer(index).map(end => aaa(end, count + 1)).max
        } else {
          -1
        }
      }
    }

    val max = aaa(-1, 0)

    //println(max)




//    if (fibHash.contains(leafB - leafA)) {
//      //println(leafA, leafB, leafA - leafB)
//      if (buffer.contains(i))
//        buffer.append((leafA, leafB))
//    }
//
//
//    for {
//      i <- leafIndices.indices
//      leafA = leafIndices(i)
//      j <- i + 1 until leafIndices.length
//      leafB = leafIndices(j)
//    } {
//      if (fibHash.contains(leafB - leafA)) {
//        //println(leafA, leafB, leafA - leafB)
//        buffer.append((leafA, leafB))
//      }
//    }
//    println(buffer)

//    val startGroup = buffer.groupBy(_._1)
//    val endGroup = buffer.groupBy(_._2)


//    startGroup(-1).foreach {
//      case (start, end) =>
//        var _end = 0

//        def aaa(startIndex:Int, count: Int): Int = {
//          if (startIndex >= a.length + 1) {
//            count
//          } else {
//            if (startGroup.contains(startIndex)) {
//
//            } else {
//              -1
//            }
//          }
//        }

//        import scala.util.control.Breaks._
//        breakable {
//          while (_end == a.length + 1) {
//            if (startGroup.contains(_end)) {
//              startGroup(_end)
//              _end = startGroup(_end)
//            } else {
//              break
//            }
//          }
//        }




//        if (startGroup.contains(end)) {
//          startGroup(end).foreach {
//            case (start2, end2) =>
//              if (startGroup.contains(end2)) {
//
//              }
//          }
//        }
//    }

//    startGroup.foreach {
//      case (start, list) =>
//        list.foreach {
//          case (_, end) =>
//            if (!endGroup.contains(end)) {
//              //endGroup.remove
//            }
//        }
//    }
//
//    var i = 0
//    while (i == a.length + 1) {
//
//    }







    for (i <- leafIndices.indices) {
      println(i)
      for (j <- i + 1 until leafIndices.length) {
        if (fibHash.contains(leafIndices(j) - leafIndices(i))) {
          println(leafIndices(i), leafIndices(j))
          (leafIndices(i), leafIndices(j))
        } else {

        }
      }
    }
//
//    for (i <- a.indices) {
//      for (fib <- fibNums) {
//
//      }
//    }




//    for (i <- -1 until a.length) {
//      fibNums.dropRight(1).find { p =>
//        val fib = p.toInt
//        if (a(i + fib) == 1) {
//          println(s"find $i, a(${i + p})=[${a(i + p.toInt)}]")
//        }
//        true
//      }
//    }
    0
  }
  println(solution2(Array(0,0,0,1,1,0,1,0,0,0,0)))
}


