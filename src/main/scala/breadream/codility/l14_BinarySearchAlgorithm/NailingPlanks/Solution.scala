package breadream.codility.l14_BinarySearchAlgorithm.NailingPlanks

import scala.collection.mutable.SortedSet

/**
  * NailingPlanks
  *
  * Count the minimum number of nails that allow a series of planks to be nailed.
  * 일련의 널빤지를 못으로 고정할 수 있는 최소 못의 수를 세십시오.
  *
  * You are given two non-empty arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.
  * N 정수로 구성된 비어 있지 않은 배열 A와 B 두 개가 주어진다. 이 배열들은 N개의 널빤지를 나타낸다. 더 정확히 말하면, A[K]는 K번째 판자의 시작이고 B[K]는 끝이다.
  *
  * Next, you are given a non-empty array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.
  * 다음에는 M 정수로 구성된 비어 있지 않은 배열 C가 주어진다. 이 배열은 M네일을 나타낸다. 더 정확히 말하면, C[I]는 I-th 못을 박을 수 있는 위치다.
  *
  * We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that
  * A[K] ≤ C[I] ≤ B[K].
  * 우리는 판자(A[K], B[K])가 A[K] ≤ C[I] ≤ B[K]와 같은 못 C[I]가 있으면 못을 박는다고 말한다
  *
  *
  * The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].
  *
  *
  *
  * A[0] = 1    B[0] = 4
  * A[1] = 4    B[1] = 5
  * A[2] = 5    B[2] = 9
  * A[3] = 8    B[3] = 10
  *
  * C[0] = 4
  * C[1] = 6
  * C[2] = 7
  * C[3] = 10
  * C[4] = 2
  *
  *
  *
  *
  *
  */
object Solution extends App {

  import scala.collection.mutable

  def isAllNailed(mid: Int, set: mutable.SortedSet[(Int, Int)], c: Array[Int]): Boolean = {
    //println(mid)

    val buffer = set.clone

    //println(buffer)
    c.slice(0, mid + 1).foreach { nail =>
      val hits = buffer.filter {
        case (start, end) =>
          start <= nail && nail <= end
      }
      hits.foreach(buffer.remove)
      if (buffer.isEmpty){
        //println(s"mid($mid) success")
        return true
      }
    }
    //println(s"mid($mid) fail")
    false
  }

  def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    val buffer = mutable.SortedSet.empty[(Int, Int)](Ordering.by(_._1))
    a.indices.foreach { i =>
      buffer.add(a(i), b(i))
    }
    println(buffer)
    var (min, max) = (0, c.length - 1)
    var result = -1
    while (min <= max) {
      val mid = (min + max) / 2
      if (isAllNailed(mid, buffer, c)) {
        result = mid
        //println(s"gogo to down ${(min, max)} -> ${(min, mid - 1)}")
        max = mid - 1
      } else {
        //println(s"gogo to up ${(min, max)} -> ${(mid + 1, max)}")
        min = mid + 1
      }
    }
    if (result < 0) -1 else result + 1
  }

  def solution2(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    val buffer = mutable.SortedSet.empty[(Int, Int)](Ordering.by(_._1))
    a.indices.foreach { i =>
      buffer.add(a(i), b(i))
    }
    //println(buffer)
    var count = 0
    c.iterator.takeWhile(_ => buffer.nonEmpty).foreach { nail =>
      val hits = buffer.filter {
        case (start, end) =>
          start <= nail && nail <= end
      }
      hits.foreach(buffer.remove)
      count += 1
    }
    if (buffer.nonEmpty) -1 else count
  }

//  println(solution(Array(1, 4, 5, 8), Array(4, 5, 9, 10), Array(4, 6, 7, 10, 2)))
//  println(solution(Array(1), Array(1), Array(2)))

//  println(solution2(Array(1, 4, 5, 8), Array(4, 5, 9, 10), Array(4, 6, 7, 10, 2)))
//  println(solution2(Array(1), Array(1), Array(2)))


  import breadream.hackerRank.common.Random.between

//  val M = 30000
//  val N = 100
  val M = 3000
  val N = 100

  val _a = Array.fill(N){0}
  val _b = Array.fill(N){0}
  val _c = Array.fill(N){0}

  (0 until N).foreach { i =>
    _a(i) = between(1, 2 * M - M)
    _b(i) = between(_a(i) + M, 2 * M)
    _c(i) = between(1, 2 * M)
  }

  println(_a.toList)
  println(_b.toList)
  println(_c.toList)

  println(solution2(_a, _b, _c))
  println(solution(_a, _b, _c))



}


