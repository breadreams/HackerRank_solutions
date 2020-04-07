package hackerRank.solutions.DictionariesAndHashmaps.HashTables_RansomNote

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

/**
  * @see [[https://www.hackerrank.com/challenges/ctci-ransom-note/problem]]
  */
object Solution {

  // Complete the checkMagazine function below.
  def checkMagazine(magazine: Array[String], note: Array[String]) {
    val mArr = magazine.groupBy(t => t).map(_._2.zipWithIndex.map(t => t._1 + "_" + t._2)).flatten.toList
    val nArr = note.groupBy(t => t).map(_._2.zipWithIndex.map(t => t._1 + "_" + t._2)).flatten.toList
    if (nArr.diff(mArr).isEmpty) {
      println("Yes")
    } else {
      println("No")
    }
  }

  def main(args: Array[String]): Unit = {
    val arguments = Array(
      ("two times three is not four", "two times two is four") // No
      ,("give me one grand today night","give one grand today") // Yes
      ,("ive got a lovely bunch of coconuts","ive got some coconuts") // Yes
    )
    arguments.foreach {
      case (a1, a2) =>
        val rst = checkMagazine(a1.split(" ").map(_.trim), a2.split(" ").map(_.trim))
        println(rst)
    }
  }
  /*
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val mn = stdin.readLine.split(" ")

    val m = mn(0).trim.toInt

    val n = mn(1).trim.toInt

    val magazine = stdin.readLine.split(" ")

    val note = stdin.readLine.split(" ")
    checkMagazine(magazine, note)
  }
  */
}

