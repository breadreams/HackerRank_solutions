package breadream.hackerRank.common

import breadream.hackerRank.common.util.JsonUtil

object CountingSort {
    def countingSort(arr: Array[Int], max: Int): Array[Int] = {
        //println(s"arr : ${JsonUtil.toJson(arr)}")
        val counterArr = Array.fill(max + 1){0}
        arr.foreach { v =>
            counterArr(v) += 1
        }
        //println(s"counterArr : ${JsonUtil.toJson(counterArr)}")
        val counterSumArr = counterArr.scanLeft(0)(_+_).drop(1)
        //println(s"counterSumArr : ${JsonUtil.toJson(counterSumArr)}")
        val resultArr = Array.fill(arr.length){0}
        for (item <- arr) {
            resultArr(counterSumArr(item) - 1) = item
            counterSumArr(item) -= 1
        }
        resultArr
    }
}

