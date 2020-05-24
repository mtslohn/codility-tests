package codility.lessons;

public class PassingCars {

    public int solutionA(int[] A) {
        int pairs = 0;
        int referenceValue = 0;

        // int lastIndexToProcess = -1;

        for (int i = 0; i < A.length; i++) {
            if (referenceValue != A[i]) { // ignores the search
                continue;
            }
            int thisPairs = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] != A[j]) {
                    thisPairs++;
                }
            }
            if (thisPairs == 0) {
                //lastIndexToProcess = i - 1;
                break;
            }
            pairs += thisPairs;
        }

        /*if (lastIndexToProcess != -1) {
            while (lastIndexToProcess > 0 && A[lastIndexToProcess - 1] != referenceValue) {
                lastIndexToProcess--;
            }

            for (int i = lastIndexToProcess; i < A.length; i++) {
                if (referenceValue == A[i]) { // ignores the search
                    continue;
                }
                int thisPairs = 0;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i] != A[j]) {
                        thisPairs++;
                    }
                }
                pairs += thisPairs;
            }
        }*/

        return pairs;
    }

    public int solutionB(int[] A) {
        int[] prefixedSumsEast = new int[A.length + 1];
        int[] prefixedSumsWest = new int[A.length + 1];

        int lastWestChange = -1;

        for (int i = 0; i < A.length; i++) {
            prefixedSumsEast[i + 1] = prefixedSumsEast[i];
            prefixedSumsWest[i + 1] = prefixedSumsWest[i];
            if (A[i] == 0) {
                prefixedSumsEast[i + 1] += 1;
            } else {
                prefixedSumsWest[i + 1] += 1;
                lastWestChange = i + 1;
            }
        }

        /*System.out.println(Arrays.stream(prefixedSumsEast).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(prefixedSumsWest).boxed().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println("---------");

        if (1 == 1) return -1;*/

        int pairs = 0;
        int ref = 0;
        for (int i = 0; i < prefixedSumsEast.length; i++) {
            if (prefixedSumsEast[i] == ref) {
                continue;
            }
            ref = prefixedSumsEast[i];
            pairs += prefixedSumsWest[prefixedSumsWest.length - 1] - prefixedSumsWest[i];
        }

        if (lastWestChange != -1 && A[A.length - 1] == A[0]) {
            pairs += (A.length - lastWestChange) * 2;
        }

        return pairs;
    }

    public int solutionC(int[] A) {
        int eastCars = 0;
        int pairs = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                eastCars++;
            } else {
                pairs += eastCars;
            }
            if (pairs > 1_000_000_000) {
                pairs = -1;
                break;
            }
        }

        return pairs;
    }

}
