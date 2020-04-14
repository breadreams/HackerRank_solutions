package breadream.codility.l10_PrimeAndCompositeNumbers.Flags;

import java.util.ArrayList;

public class Flags {
    public static int solution(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        //Create an arraylist of peaks
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        //if the size of peaks is 1 or 0, return
        int size = peaks.size();
        if (size == 1 || size == 0) {
            return size;
        }

        //Initial number of flags = 1
        int result = 1;
        int x = 1;
        while (x <= size) {
            int flag = (x + size) / 2;
            boolean success = false;
            int used = 0;
            int mark = peaks.get(0);
            for (int i = 0; i < peaks.size(); i++) {
                if (peaks.get(i) >= mark) {
                    used++;
                    mark = peaks.get(i) + flag;
                    if (used == flag) {
                        success = true;
                        break;
                    }
                }
            }
            if (success) {
                result = flag;
                x = flag + 1;
            } else {
                size = flag - 1;
            }
        }
        return result;
    }
}