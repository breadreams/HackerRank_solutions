package breadream.codility.l7_StacksAndQueues.StoneWall

/**
  * StoneWall
  *
  * Cover "Manhattan skyline" using the minimum number of rectangles.
  *
  * You are going to build a stone wall.
  * 너는 돌담을 쌓을 것이다.
  *
  * The wall should be straight and N meters long, and its thickness should be constant;
  * 벽은 직선이며 N미터 길이여야 하며 두께는 일정해야한다.
  *
  * however, it should have different heights in different places.
  * 하지만 장소마다 높이가 달라야 한다.
  *
  * The height of the wall is specified by an array H of N positive integers.
  * 벽의 높이는 N 양의 정수 배열 H에 의해 지정된다.
  *
  * H[I] is the height of the wall from I to I+1 meters to the right of its left end.
  * H[I]는 I ~ I+1 미터 까지의 벽 높이다.
  *
  * In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
  * 특히 H[0]는 벽의 왼쪽 끝 높이, H[N-1]는 벽의 오른쪽 끝 높이.
  *
  *
  * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
  * 벽은 사각형의 돌 블록(즉, 그러한 블록의 모든 면이 직사각형)으로 만들어져야 한다. 당신의 임무는 벽을 세우는 데 필요한 최소 블록 수를 계산하는 것이다.
  *
  *
  * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
  * 벽의 높이를 지정하는 N 양의 정수 배열 H가 주어진 경우, 벽의 높이에 필요한 최소 블록 수를 반환한다.
  *
  * For example, given array H containing N = 9 integers:
  *
  * H[0] = 8    H[1] = 8    H[2] = 5
  * H[3] = 7    H[4] = 9    H[5] = 8
  * H[6] = 7    H[7] = 4    H[8] = 8
  *
  * the function should return 7. The figure shows one possible arrangement of seven blocks.
  * 함수는 7을 반환해야 한다. 이 그림은 7블록의 가능한 배열 하나를 보여준다.
  *
  *
  */
object Solution {
  def solution(h: Array[Int]): Int = {

    0
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(8,8,5,7,9,8,7,4,8)))
  }
}
