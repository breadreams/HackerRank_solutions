

##Chapter 16

###Greedy algorithms

We consider problems in which a result comprises a sequence of steps or choices that have to be made to achieve the optimal solution. 
Greedy programming is a method by which a solution is determined based on making the locally optimal choice at any given moment. 
In other words, we choose the best decision from the viewpoint of the current stage of the solution

우리는 최적의 해결책을 달성하기 위해 이루어져야 하는 일련의 단계나 선택으로 결과가 구성되는 문제를 고려한다. 
탐욕스러운 프로그래밍은 주어진 순간에 국지적으로 최적의 선택을 하는 것에 기초하여 해결책이 결정되는 방법이다.
즉, 해결의 현 단계적 관점에서 최선의 결정을 선택한다.

Depending on the problem, the greedy method of solving a task may or may not be the best approach. 
If it is not the best approach, then it often returns a result which is approximately correct but suboptimal. 
In such cases dynamic programming or brute-force can be the optimal approach. 
On the other hand, if it works correctly, its running time is usually faster than those of dynamic programming or brute-force.

문제에 따라 탐욕스러운 해결 방법이 최선의 방법이 될 수도 있고 아닐 수도 있다.
그것이 최선의 방법이 아니라면, 그것은 종종 거의 정확하지만 차선의 결과를 반환한다.
이러한 경우 동적 프로그래밍 또는 브루트 포스가 최적의 접근 방법이 될 수 있다.
반면에, 그것이 제대로 작동한다면, 그것의 실행 시간은 대개 동적 프로그래밍이나 브루트 포스보다 더 빠르다.

####16.1. The Coin Changing problem
16.1. 동전 교환 문제

For a given set of denominations, you are asked to find the minimum number of coins withwhich a given amount of money can be paid.
That problem can be approached by a greedyalgorithm that always selects the largest denomination not exceeding the remaining amountof money to be paid.
As long as the remaining amount is greater than zero, the process isrepeated.

주어진 액수의 액수를 지불할 수 있는 최소한의 동전을 찾도록 요청 받는다.
그 문제는 항상 지불해야 할 남은 금액을 초과하지 않는 가장 큰 단위를 선택하는 탐욕적인 알고리즘에 의해 접근될 수 있다.
남은 양이 0보다 크기만 하면 공정이 반복된다.

A correct algorithm should always return the minimum number of coins.
It turns outthat the greedy algorithm is correct for only some denomination selections, but not for all.
For example, for coins of values 1, 2 and 5 the algorithm returns the optimal number ofcoins for each amount of money, but for coins of values 1, 3 and 4 the algorithm may returna suboptimal result.
An amount of 6 will be paid with three coins: 4, 1 and 1 by using thegreedy algorithm.
The optimal number of coins is actually only two: 3 and 3.

정확한 알고리즘은 항상 최소 동전의 수를 반환해야 한다.
탐욕스러운 알고리즘은 일부 교파 선택에 대해서만 정확하지만, 전혀 그렇지 않다는 것이 밝혀졌다.
예를 들어, 값 1, 2, 5의 동전의 경우 알고리즘은 각 금액에 대해 최적의 코인 수를 반환하지만 값 1, 3, 4의 동전의 경우 알고리즘은 차선의 결과를 반환할 수 있다.
6개의 금액은 자유 알고리즘을 사용하여 4, 1, 1의 세 개의 동전으로 지불될 것이다.
동전의 최적 개수는 사실 3과 3 두 개에 불과하다.

Consider n denominations 0 < m0 <= m1 <= . . . <= mn−1 and the amount k to be paid.
n개 교파 0 <= m1 <= . . . . . <= mn-1 과 지불해야 할 금액 k를 고려한다

python

    def greedyCoinChanging(M, k):
        n = len(M)
        result = []
        for i in xrange(n - 1, -1, -1):
            result += [(M[i], k // M[i])]
            k %= M[i]
        return result

scala

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
    
The function returns the list of pairs: denomination, number of coins. 
The time complexity of the above algorithm is O(n) as the number of coins is added once for every denomination.
함수는 페어 리스트를 반환한다: 디노미네이션, 동전 수. 
위 알고리즘의 시간 복잡성은 각 단위에 한 번씩 동전의 개수를 더하기 때문에 O(n)이다.


####16.2. Proving correctness
16.2. 정확성 입증

If we construct an optimal solution by making consecutive choices,
then such a property canbe proved by induction: 
if there exists an optimal solution consistent with the choices thathave been made so far, then there also has to exist an optimal solution consistent with thenext choice (including the situation when the first choice is made).

우리가 연속적인 선택을 함으로써 최적의 솔루션을 구축한다면, 
그러한 속성은 유도에 의해 증명될 수 있다: 
만약 지금까지 이루어진 선택과 일치하는 최적의 솔루션이 있다면, 
그 선택과 일치하는 최적의 솔루션도 존재해야 한다(첫 번째 선택이 이루어지는 상황 포함).


####16.3. Exercise
16.3. 연습문제

Problem: There are n > 0 canoeists weighing respectively 1 <= w0 <= w1 <= . . . <= wn−1 <= 10^9.
The goal is to seat them in the minimum number of double canoes whose displacement (the maximum load) equals k. 
You may assume that wi <= k.

문제: 무게가 각각 1 <= w0 <= w1 <= . . . . .<= 10^9 인 카누가 있다.
목표는 변위(최대 하중)가 k인 최소 이중 카누 수에 이들을 앉히는 것이다.
wi <=k 라고 가정해도 좋다.



Solution A O(n): The task can be solved by using a greedy algorithm.
The heaviest canoeistis called fatso.
Other canoeists who can be seated with fatso in the canoe are called skinny.
All the other remaining canoeists are also called fatsos.
The idea is that, for the heaviest fatso, we should find the heaviest skinny who can beseated with him.
So, we seat together the heaviest fatso and the heaviest skinny.
Let us notethat the thinner the heaviest fatso is, the fatter skinny can be.
Thus, the division betweenfatso and skinny will change over time — as the heaviest fatso gets closer to the pool ofskinnies.

솔루션 A O(n): 탐욕스러운 알고리즘을 사용하여 과제를 해결할 수 있다.
가장 무거운 카누스티스는 fatso라고 불렀다.
카누에 지방소를 깔고 앉을 수 있는 다른 카누를 스키니라고 부른다.
나머지 카누리스트들은 모두 fatos라고 불리기도 한다.
그 아이디어는, 가장 무거운 지방을 위해서는, 그와 함께 식사할 수 있는 가장 무거운 스키니를 찾아야 한다는 것이다.
그래서 우리는 가장 무거운 지방과 가장 무거운 마른 지방을 함께 앉힌다.
가장 얇은 지방보다 더 뚱뚱한 지방일수록 더 뚱뚱해질 수 있다.
따라서, 지방소와 마른 지방 사이의 구분이 시간이 지남에 따라 바뀔 것이다. 가장 무거운 지방소가 피부 덩어리에 가까워지기 때문이다.


python

    def greedyCanoeistA(W, k):
        N = len(W)
        skinny = deque()
        fatso = deque()
        for i in xrange(N - 1):
            if W[i] + W[-1] <= k:
                skinny.append(W[i])
            else:
                fatso.append(W[i])
        fatso.append(W[-1])
        canoes = 0
        while (skinny or fatso):
            if len(skinny) > 0:
                skinny.pop()
            fatso.pop()
            canoes += 1
            if (not fatso and skinny):
                fatso.append(skinny.pop())
                while (len(fatso) > 1 and fatso[-1] + fatso[0] <= k):
                    skinny.append(fatso.popleft())
        return canoes


    def greedyCanoeistB(W, k):
        canoes = 0
        j = 0
        i = len(W) - 1
        while (i >= j):
            if W[i] + W[j] <= k:
                j += 1;
            canoes += 1;
            i -= 1
        return canoes


scala

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

