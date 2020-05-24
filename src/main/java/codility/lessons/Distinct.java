package codility.lessons;

import java.util.Arrays;

public class Distinct {

    public int solution(int[] A) {
        // sorts with Quicksort
        Arrays.sort(A);

        int count = 0;
        if (A.length > 0) {
            int refVal = A[0];
            count++;
            for (int i = 0; i < A.length; i++) {
                if (refVal != A[i]) {
                    refVal = A[i];
                    count++;
                }
            }
        }

        return count;
    }

}
