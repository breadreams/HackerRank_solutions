package breadream.hackerRank.common

object Note extends App {

  import scala.util.control.Breaks._
  breakable {
  }

  /*
  def main(args: Array[String]): Unit = {
    println(solution(5, Array(
      3, 4, 4, 6, 1, 4, 4
    )))
  }

  import scala.collection.mutable.Map.empty
  val tempMap = empty[Int, Int].withDefaultValue(0)


  val tempArr = Array.fill(n){0}

  val stack = new scala.collection.mutable.Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop)
  => 2

  val queue = new scala.collection.mutable.Queue[String]
  queue += "a"
  queue ++= List("b", "c")
  println(queue.dequeue)
  => a

  */

  val aaa =  Array(1,2,3)
  //aaa.map(_ => 3)
  aaa.indices.foreach(aaa(_) = 3)
  println(aaa.toList)
}
