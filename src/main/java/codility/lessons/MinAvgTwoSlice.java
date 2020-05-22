package codility.lessons;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinAvgTwoSlice {

    public int firstSolution(int[] A) {
        double[][] prefixedSums = new double[A.length][A.length];
        int lowestIndex = -1;
        double lowestValue = Double.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {

            // makes the prefixed sum
            prefixedSums[i][i] = A[i];
            for (int j = i + 1; j < A.length; j++) {
                prefixedSums[i][j] = prefixedSums[i][j - 1] + A[j];
            }

            // calculates avg
            for (int j = i + 1; j < A.length; j++) {
                prefixedSums[i][j] = prefixedSums[i][j] / (j - i + 1);
                if (prefixedSums[i][j] < lowestValue) {
                    lowestIndex = i;
                    lowestValue = prefixedSums[i][j];
                }
            }
        }

        for (int i = 0; i < prefixedSums.length; i++) {
            prefixedSums[i][i] = 0;
        }

        DecimalFormat formatter = new DecimalFormat("0.00");

        System.out.println(Arrays.stream(prefixedSums).map(
                line -> Arrays.stream(line).boxed().map(formatter::format).collect(Collectors.joining("\t"))
        ).collect(Collectors.joining("\n")));
        return lowestIndex;
    }

    public int secondSolution(int[] A) {
        double[] prefixedSums = new double[A.length];
        int lowestIndex = -1;
        double lowestValue = Double.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {

            // makes the prefixed sum
            int indexPrefixedSum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                indexPrefixedSum += A[j];
                prefixedSums[j] = indexPrefixedSum / (j - i + 1.0);
                if (prefixedSums[j] < lowestValue) {
                    lowestIndex = i;
                    lowestValue = prefixedSums[j];
                }
            }

        }

        return lowestIndex;
    }

    public int thirdSolution(int[] A) {


        int cumulativeSum = A[0] + A[1];
        double minAvg = cumulativeSum / 2.0;

        int elCount = 2;
        int minIndex = 0;
        int i = 2;

        int candidadeIndex = 0;

        while (i < A.length) {
            cumulativeSum += A[i];
            elCount++;
            double avg = cumulativeSum / (elCount * 1.0);
            if (avg >= minAvg) {
                cumulativeSum = A[i] + A[i - 1];
                candidadeIndex = i - 1;
                elCount = 2;
                avg = cumulativeSum / (elCount * 1.0);
                if (avg < minAvg) {
                    minAvg = avg;
                    minIndex = candidadeIndex;
                }
            } else {
                minAvg = avg;
                minIndex = candidadeIndex;
                boolean doAgain = false;
                do {
                    avg = (cumulativeSum - A[candidadeIndex]) / (elCount - 1.0);
                    if (avg < minAvg) {
                        doAgain = true;
                        cumulativeSum -= A[candidadeIndex];
                        elCount--;
                        candidadeIndex++;
                        minAvg = avg;
                        minIndex = candidadeIndex;
                    }
                } while (doAgain && elCount > 2);
            }
            i++;
        }

        return minIndex;

    }
}
