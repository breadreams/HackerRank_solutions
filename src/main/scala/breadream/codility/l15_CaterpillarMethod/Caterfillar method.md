Chapter 15

Caterpillar method

The Caterpillar method is a likeable name for a popular means of solving algorithmic tasks. 
The idea is to check elements in a way that’s reminiscent of movements of a caterpillar.
The caterpillar crawls through the array. We remember the front and back positions of the
caterpillar, and at every step either of them is moved forward.

캐터필러 방식은 알고리즘 과제를 해결하는 인기 있는 수단과 비슷한 이름이다.
애벌레의 움직임을 연상시키는 방식으로 원소를 점검하겠다는 겁니다.
애벌레가 배열을 기어다닌다. 앞쪽과 뒷쪽 위치를 기억한다.
애벌레, 그리고 매 걸음마다 그들 중 한 사람이 앞으로 나아간다.

15.1. Usage example

Let’s check whether a sequence a0, a1, . . . , an−1 (1 <= ai < 10^9) contains a contiguous subsequence whose sum of elements equals s. 
For example, in the following sequence we are looking for a subsequence whose total equals s = 12.

순서 a0, a1, . , an-1 (1 = ai < 10^9)이 원소의 합이 s와 같은 연속적인 연속적인 반복성을 포함하고 있는지 확인해보자.
예를 들어, 다음 순서에서 우리는 총계가 s = 12인 부분수치를 찾고 있다.


6, 2, 7, 4, 1, 3, 6
      o  o  o


Each position of the caterpillar will represent a different contiguous subsequence in which
the total of the elements is not greater than s. Let’s initially set the caterpillar on the first
element. Next we will perform the following steps:

애벌레의 각 위치는 다음과 같은 서로 다른 연속적인 반복성을 나타낼 것이다.
원소의 총합은 s보다 크지 않다. 애벌레는 처음에 첫 번째에 설치하자.
원소의 다음으로 다음 단계를 수행하십시오.

• if we can, we move the right end (front) forward and increase the size of the caterpillar;

• 가능하면 오른쪽 끝으로 이동하여 애벌레의 크기를 증가시킨다.

• otherwise, we move the left end (back) forward and decrease the size of the caterpillar.

• 그렇지 않으면 왼쪽 끝으로 이동하여 애벌레의 크기를 줄인다.

In this way, for every position of the left end we know the longest caterpillar that covers
elements whose total is not greater than s. If there is a subsequence whose total of elements
equals s, then there certainly is a moment when the caterpillar covers all its elements.

이렇게 해서 왼쪽 끝의 모든 위치에 대해 우리는 가장 긴 애벌레가 덮고 있는 것을 안다.
합계가 s보다 크지 않은 요소 원소의 총합이 있는 부분군이 있는 경우
s와 같을 때, 애벌레가 모든 원소를 덮는 순간이 분명히 있다.

python

    def caterpillarMethod(A, s):
        n = len(A)
        front, total = 0, 0
        for back in xrange(n):
            while (front < n and total + A[front] <= s):
                total += A[front]
                front += 1
            if total == s:
                return True
            total -= A[back]
scala

    def caterpillarMethod(a: Array[Int], s: Int): Boolean = {
      val n = a.length
      var (front, total) = (0, 0)
      for (back <- a.indices) {
        while (front < n && total + a(front) <= s) {
          total += a(front)
          front += 1
        }
        if (total == s) return true
        total -= a(back)
      }
      false
    }

Let’s estimate the time complexity of the above algorithm. At the first glance we have two
nested loops, what suggest quadratic time. However, notice that at every step we move the
front or the back of the caterpillar, and their positions will never exceed n. Thus we actually
get an O(n) solution.
The above estimation of time complexity is based on amortized cost, which will be explained more precisely in future lessons.

위의 알고리즘의 시간 복잡성을 추정해 보자. 첫눈에 우리에겐 두 가지가 있다.
중첩된 루프, 2차 시간을 나타내는 값. 하지만, 우리가 모든 단계에서
애벌레의 앞이나 뒷면, 그리고 그들의 위치는 결코 n을 넘지 않을 것이다. 그래서 우리는 실제로
O(n) 해결책을 얻다
위의 시간 복잡성의 추정은 상각후원가에 기초하며, 향후 수업에서 보다 정확하게 설명될 것이다.


15.2. Exercise

Problem: You are given n sticks (of lengths 1 <= a0 <= a1 <= . . . <= an−1 <= 10^9). The goal is
to count the number of triangles that can be constructed using these sticks. More precisely,
we have to count the number of triplets at indices x < y < z, such that ax + ay > az.

문제: (길이가 1 <= a0 <= a1 <= . . . . . . . . )은 n개의 막대기를 받는다. 목표는
이러한 스틱을 사용하여 구성할 수 있는 삼각형의 수를 계산한다. 좀 더 정확히 말하면,
지수 x < y < z, 그 a(x) + a(y) > a(z)에서 세 쌍둥이의 수를 세어야 한다.

Solution O(n2): For every pair x, y we can find the largest stick z that can be used to
construct the triangle. Every stick k, such that y < k <= z, can also be used, because the
condition ax + ay > ak will still be true. We can add up all these triangles at once.

솔루션 O(n2): 모든 쌍 x, y에서 사용할 수 있는 가장 큰 스틱 z를 찾을 수 있음
삼각형을 짓다 y < k <= z 와 같은 모든 막대 k도 사용할 수 있는데, 그 이유는 다음과 같다.
ax + ay > ak는 여전히 진실일 것이다. 우리는 이 삼각형들을 한번에 모두 합칠 수 있다.


If the value z is found every time from the beginning then we get a O(n^3) time complexity solution. 
However, we can instead use the caterpillar method. When increasing the value of y, we can increase (as far as possible) the value of z.

처음부터 매번 값 z가 발견되면 O(n^3) 시간 복잡성 솔루션을 얻을 수 있다.
하지만, 우리는 대신 애벌레 방법을 사용할 수 있다. y의 값을 증가시킬 때, 우리는 z의 값을 증가시킬 수 있다.

python

    def triangles(A):
        n = len(A)
        result = 0
        for x in xrange(n):
            z = x + 2
            for y in xrange(x + 1, n):
                while (z < n and A[x] + A[y] > A[z]):
                    z += 1
            result += z - y - 1
    return result
    
    
scala



The time complexity of the above algorithm is O(n^2), because for every stick x the values of y and z increase O(n) number of times.

위의 알고리즘의 시간 복잡성은 O(n^2)이며, 모든 스틱 x에 대해 y와 z의 값이 O(n) 횟수를 증가시키기 때문이다.
