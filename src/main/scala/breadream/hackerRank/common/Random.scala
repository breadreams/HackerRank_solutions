package breadream.hackerRank.common

import scala.annotation.tailrec

object Random extends scala.util.Random {

  def between(minInclusive: Int, maxExclusive: Int): Int = {
    require(minInclusive < maxExclusive, "Invalid bounds")

    val difference = maxExclusive - minInclusive
    if (difference >= 0) {
      nextInt(difference) + minInclusive
    } else {
      @tailrec
      def loop(): Int = {
        val n = nextInt()
        if (n >= minInclusive && n < maxExclusive) n
        else loop()
      }
      loop()
    }
  }
}
