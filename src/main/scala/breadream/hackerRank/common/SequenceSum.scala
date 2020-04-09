package breadream.hackerRank.common

object SequenceSum {
  def sum(min: Int, max: Int): Long = {
    (min + max) * (max - min + 1) / 2
  }
}
