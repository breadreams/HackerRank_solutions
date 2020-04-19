package breadream.a_coding_test.task2;

class Solution {
    public static void main(String [] args) {
        int [] input = new int[]{1,4,-1,3,2};
        System.out.println(solution(input));
    }

    public static int solution(int [] args) {
        int length = args.length;
        int count = 0;
        int value = 0;
        int i = 0;
        while(value < 0) {
            if(args[i] < 0) {
                count++;
                break;
            } else {
                i = args[i];
                value = args[i];
                count++;
            }
        }
        return count;
    }
}
