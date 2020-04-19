package breadream.codility.l16_GreedyAlgorithms

object GreedyAlgorithms extends App {

  import scala.collection.mutable
  def greedyCoinChanging(m: Array[Int], k: Int): mutable.ListBuffer[(Int, Int)]= {
    val n = m.length
    var amount = k
    val result = mutable.ListBuffer.empty[(Int, Int)]
    for (i <- n - 1 to 0 by -1) {
      result.append((m(i), amount / m(i)))
      amount = amount % m(i)
    }
    //println(result)
    result
  }

//  println(greedyCoinChanging(Array(1,5,10,100), 225))

  def greedyCanoeistA(w: Array[Int], k: Int): mutable.ListBuffer[(Int, Int)]= {

    val n = w.length
    val skinny = mutable.ListBuffer.empty[Int]
    val fatso = mutable.ListBuffer.empty[Int]

    for (i <- 0 until n - 1) {
      if (w(i) + w.last <= k) {
        skinny.append(w(i))
      } else {
        fatso.append(w(i))
      }
    }
    fatso.append(w.last)

    println(w.toList)
    println(skinny)
    println(fatso)

    var canoes = 0

    while (skinny.nonEmpty && fatso.nonEmpty) {
      if (skinny.nonEmpty) {
        skinny.remove(skinny.length - 1)
      }
      fatso.remove(fatso.length - 1)
      canoes += 1

      if (fatso.isEmpty && skinny.nonEmpty) {
        fatso.append()
      }
    }
    null
  }

  def greedyCanoeistB(w: Array[Int], k: Int): Int = {
    var canoes = 0
    var j = 0
    var i = w.length - 1

    while (i >= j) {
      if (w(i) + w(j) <= k) {
        j += 1
      }
      canoes += 1
      i -= 1
    }
    canoes
  }


  println(greedyCanoeistA(Array(1,5,10,100,110,120,130), 225))
  println(greedyCanoeistB(Array(1,5,10,100,110,120,130), 225))




}
