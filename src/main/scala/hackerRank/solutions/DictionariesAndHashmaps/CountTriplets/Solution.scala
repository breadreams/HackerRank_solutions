package hackerRank.solutions.DictionariesAndHashmaps.CountTriplets

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import hackerRank.common.util.JsonUtil

import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._

import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

/**
  * @see [[https://www.hackerrank.com/challenges/count-triplets-1/problem]]
  */
object Solution {

    def countTriplets2(arr: Array[Long], r: Long): Long = {

        import scala.collection.mutable.Map.empty

        val aMap = arr.groupBy(a => a).mapValues(_.length)

        arr.indices.combinations(3).foreach(println)

        println(arr.indices.combinations(3).size)
        println(arr.filter(a => aMap.contains(a / r) && aMap.contains(a) && aMap.contains(a * r)).toList)





        println(arr.zipWithIndex.filter { t =>
            val (a, index) = t
            aMap.contains(a / r) && aMap.contains(a) && aMap.contains(a * r)
        }.toList)


//        1 , 2, 2, 4

        arr.foreach { a =>
            if (aMap.contains(a / r) && aMap.contains(a) && aMap.contains(a * r)) {
                aMap(a / r) * aMap(a * r)
            }
        }





        0




//
//        arr.foreach (a => large(a) += 1)
//        println(s"large = ${JsonUtil.toJson(large, true)}")
//        arr.foreach { a =>
//            large(a) -= 1
//            println(s"large = ${JsonUtil.toJson(large, true)}")
////            if (a % r == 0) {
////                total = total + large(a * r) * small(a / r)
////            }
//            small(a) += 1
//            println(s"small = ${JsonUtil.toJson(small, true)}")
//        }
////
//
//        println("-------")
//        println("small", JsonUtil.toJson(small, true))
//        println("large", JsonUtil.toJson(large, true))



//        val powTriples = arr.indices.map(Math.pow(r, _).toLong).sliding(3, 1).map(_.toList).toList
//        println(powTriples)
//
//        val cMap = arr.groupBy(a => a).map(p => p._1 -> p._2.length)
//        powTriples.foldLeft(0) {
//            case (acc, a :: b :: c :: Nil) if cMap.contains(a) && cMap.contains(b) && cMap.contains(c) =>
//                val sum = acc + (cMap(a) * cMap(b) * cMap(c))
//                println(a, b, c)
//                println(s"$acc + (${cMap(a)} * ${cMap(b)} * ${cMap(c)}) = $sum")
//                sum
//            case (acc, _) => acc
//        }

//        val allTriples = arr.indices.combinations(3).toList.map(v => Array(arr(v(0)), arr(v(1)), arr(v(2))).toList)
//        allTriples.count(powTriples.contains(_))

    }

    def countTriplets3(arr: Array[Long], r: Long): Long = {

        import scala.collection.mutable.Map.empty

        var result = 0L
        var now = 0L

        val middle = empty[Long, Long].withDefaultValue(0L)
        val last = empty[Long, Long].withDefaultValue(0L)

        arr.foreach { a =>
            now = a
            println(s"current value : $now")
            println(s"last check : ${last(now)}")
            result += last(now)
            println(s"result = $result")

            if (middle.contains(now)) {
                println("middle 에 있음")
                last(now * r) =  last(now * r) + middle(now)
                println(s"last = ${JsonUtil.toJson(last)}")
            }
            middle(now * r) += 1
            println(s"middle = ${JsonUtil.toJson(middle)}")
        }
        result
    }

    // Complete the countTriplets function below.
    def countTriplets(arr: Array[Long], r: Long): Long = {

        import scala.collection.mutable.Map.empty

        val small = empty[Long, Long].withDefaultValue(0L) // 첫번째 들어갈 녀석?
        val large = empty[Long, Long].withDefaultValue(0L) // 두번째 들어갈 녀석?

        var total = 0L
        arr.foreach { a =>
            large(a) += 1
        }
        println(JsonUtil.toJson(large))
        arr.foreach { a =>
            println(a)
            large(a) -= 1
            println(JsonUtil.toJson(large))
            if (a % r == 0) {
                println(s"large(${a*r})[=${large(a * r)}] * small(${a/r})[=${small(a / r)}] = ${(large(a * r) * small(a / r))}")
                total = total + (large(a * r) * small(a / r))
            }
            small(a) += 1
            println(JsonUtil.toJson(small))
        }
        println(total)


//        arr.foldLeft(0L) { (acc, x) =>
//            println(s"*** [$x] ***")
//            val inc = large(x)
//            println(s"inc(=h3($x)) => $inc")
//            large(x * r) += small(x)
//            small(x * r) += 1
//            println(s"small = ${JsonUtil.toJson(small)}")
//            println(s"h3 = ${JsonUtil.toJson(large)}")
//            acc + inc
//        }

        0


//        val h2 = empty[Long, Long].withDefaultValue(0L) // 첫번째 들어갈 녀석?
//        val h3 = empty[Long, Long].withDefaultValue(0L) // 두번째 들어갈 녀석?
//
//        arr.foldLeft(0L) { (acc, x) =>
//            println(s"*** $x ***")
//            val inc = h3(x)
//            println(s"inc(=h3($x)) => $inc")
//            h3(x * r) += h2(x)
//            h2(x * r) += 1
//            println(s"h2 = ${JsonUtil.toJson(h2)}")
//            println(s"h3 = ${JsonUtil.toJson(h3)}")
////            println(s"h3 = $h3, h2=$h2, inc=$inc, acc=$acc, sum=${acc+inc}")
//            acc + inc
//        }





    }


    def main(args: Array[String]): Unit = {

        // 161700
        // 1000000

        //println(Array(1,1,1,1,1).indices.combinations(3).toList)

        val arguments = Array[(Array[Long], Long)](
            ("1 2 2 4".split(" ").map(_.toLong), 2) // 2
//            , ("1 3 9 9 27 81".split(" ").map(_.toLong), 3) // 6
//            , ("1 5 5 25 125".split(" ").map(_.toLong), 5) // 4
//            ,
//            ("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1".split(" ").map(_.toLong), 1) // 161700
            ,("1 1 1 1 1 1 1 1 1 1".split(" ").map(_.toLong), 2) // 161700

        )
        arguments.foreach {
            case (a1, a2) =>
                println(countTriplets2(a1, a2))
        }
    }

    /*
    def main(args: Array[String]) {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      val nr = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val n = nr(0).toInt

      val r = nr(1).toLong

      val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toLong)
      val ans = countTriplets(arr, r)

      printWriter.println(ans)

      printWriter.close()
    }
    */
}

