import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

public class Main {

    /*A and B are integers within the range [0..2,000,000,000];
    K is an integer within the range [1..2,000,000,000];
    A ≤ B.*/

    public static void main(String[] args) {
        int a = 0;
        int b = 2000000000;
        int k = 2000000000;

        int solExample, sol;

        {
            Instant start = Instant.now();
            solExample = new Main().solutionExample(a, b, k);
            Instant end = Instant.now();
            System.out.println(new DecimalFormat().format(Duration.between(start, end).toNanos()) + " nanossegundos");
        }


        {
            Instant start = Instant.now();
            sol = new Main().solution(a, b, k);
            Instant end = Instant.now();
            System.out.println(new DecimalFormat().format(Duration.between(start, end).toNanos()) + " nanossegundos");
        }

        // referência = 1_000_000_001

        System.out.println(sol + " " + (sol == solExample));

    }

    public int solutionExample(int A, int B, int K) {
        int solution = 0;

        int aSol;
        int restoA = A % K;
        if (restoA == 0) aSol = A;
        else aSol = A + (K - restoA);

        int bSol = (B - (B % K));

        for (int i = aSol; i <= bSol; i = i + K) {
            solution++;
        }

        return solution;
    }

    public int solution(int A, int B, int K) {

        int aSol;
        int restoA = A % K;
        if (restoA == 0) aSol = A;
        else aSol = A + (K - restoA);

        int bSol = (B - (B % K));

        return (int) (((long) bSol - aSol + K) / K);

    }

}
