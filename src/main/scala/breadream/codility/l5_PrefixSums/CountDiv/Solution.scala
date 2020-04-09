package breadream.codility.l5_PrefixSums.CountDiv

/**
  * Write a function:
  *
  * object Solution { def solution(a: Int, b: Int, k: Int): Int }
  *
  * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
  *
  * { i : A ≤ i ≤ B, i mod K = 0 }
  *
  * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * A and B are integers within the range [0..2,000,000,000];
  * K is an integer within the range [1..2,000,000,000];
  * A ≤ B.
  */
object Solution {


  def solution(a: Int, b: Int, k: Int): Int = {

//    a = 5
//    b = 10
//    k = 20
//
//    a = 25
//    b = 50
//    k = 20

    // a = 6, b = 11, k = 2

//    6 -> 6
//    7 -> 8
//    8 -> 8
//    15 -> 16
//    16 -> 16
//
//
//    (7 / 2) + 1
//
//    7 + (7 / 2)  * (2 + 1)
//
//


//    a = 101
//    b = 128974848
//    k = 10240




    (math.ceil(a / k.toDouble).toInt * k to b by k).length
  }


  def main(args: Array[String]): Unit = {
    println(solution(11, 345, 17))
//    println(solution(101, 128974848, 10240))
//    println(solution(6, 11, 2))
//    println(solution(0 ,1, 1))
//    println(solution(0, 0, 2))
//    println(solution(0, 1, 2))
//    println(solution(0, 0, 11))
//    println(solution(1, 1, 11))
//    println(solution(10, 10, 5))
//    println(solution(10, 10, 7))
//    println(solution(10, 10, 20))

  }




}
