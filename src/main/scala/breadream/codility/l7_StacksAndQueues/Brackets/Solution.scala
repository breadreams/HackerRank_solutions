package breadream.codility.l7_StacksAndQueues.Brackets

/**
  * Brackets
  *
  * Determine whether a given string of parentheses (multiple types) is properly nested.
  *
  * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
  *
  * S is empty;
  * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
  * S has the form "VW" where V and W are properly nested strings.
  * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
  *
  * Write a function:
  *
  * object Solution { def solution(s: String): Int }
  *
  * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
  *
  * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
  *
  * Write an efficient algorithm for the following assumptions:
  *
  * N is an integer within the range [0..200,000];
  * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
  */
object Solution {

  def solution(s: String): Int = {
    val stack = new scala.collection.mutable.Stack[Char]
    val openMap = Map('(' -> ')', '{' -> '}', '[' -> ']')
    val closeMap = openMap.map(t => t._2 -> t._1)
    s.foreach {
      case open if openMap.contains(open) =>
        stack.push(open)
      case close if closeMap.contains(close) =>
        if (stack.isEmpty || stack.pop() != closeMap(close)) {
          return 0
        }
    }
    if (stack.isEmpty) 1 else 0
  }

  def main(args: Array[String]): Unit = {
    println(solution("{[()()]}"))
    println(solution("([)()]"))
    println(solution("{{{{"))

  }

}
