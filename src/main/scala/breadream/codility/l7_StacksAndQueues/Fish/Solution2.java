package breadream.codility.l7_StacksAndQueues.Fish;

import java.util.Stack;

public class Solution2 {

    public static int solution(int[] A, int[] B) {
        Stack<Integer> down = new Stack<Integer>();
        int lastSize;
        int aliveCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                down.push(A[i]);
            }
            else {
                while (!down.isEmpty()) {
                    lastSize = down.peek();
                    if (lastSize > A[i]) break;
                    else down.pop();
                }
                if (down.isEmpty()) aliveCount++;
            }
        }
        return aliveCount + down.size();
    }

    public static void main(String[] arg) {
//        int[] a = new int[]{4,3,2,1,5};
//        int[] b = new int[]{0,1,0,0,0};
        int[] a = new int[]{1,1};
        int[] b = new int[]{1,0};
        System.out.println(Solution2.solution(a, b));
    }
}
