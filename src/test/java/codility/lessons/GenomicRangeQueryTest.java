package codility.lessons;

import codility.lessons.GenomicRangeQuery;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Collections.nCopies;

public class GenomicRangeQueryTest {

    @Test
    public void testA() {
        String genome = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] solution = {2, 4, 1};

        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solution(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @Test
    public void testB() {
        String genome = "A";
        int[] P = {0};
        int[] Q = {0};
        int[] solution = {1};

        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solution(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @Test
    public void testC() {
        String genome = nCopies(Integer.MAX_VALUE/20, "CGCCT").stream().collect(Collectors.joining());
        int[] P = {0};
        int[] Q = {genome.length() - 1};
        int[] solution = {2};

        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solution(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @Test
    public void testD() {
        String genome = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] solution = {2, 4, 1};

        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solutionB(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @Test
    public void testE() {
        String genome = nCopies(100000, "CGCCT").stream().collect(Collectors.joining());
        int[] P = nCopies(100000, 0).stream().mapToInt(i -> i).toArray();
        int[] Q = nCopies(100000, genome.length() - 1).stream().mapToInt(i -> i).toArray();
        int[] solution = nCopies(100000, 2).stream().mapToInt(i -> i).toArray();

        LocalDateTime a = LocalDateTime.now();
        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solutionB(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("Duração: " + Duration.between(a, LocalDateTime.now()).toMillis() + "ms");
    }

    @Test
    public void testF() {
        String genome = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] solution = {2, 4, 1};

        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solutionPrefixSum(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @Test
    public void testG() {
        String genome = nCopies(100000, "CGCCT").stream().collect(Collectors.joining());
        int[] P = nCopies(100000, 0).stream().mapToInt(i -> i).toArray();
        int[] Q = nCopies(100000, genome.length() - 1).stream().mapToInt(i -> i).toArray();
        int[] solution = nCopies(100000, 2).stream().mapToInt(i -> i).toArray();

        LocalDateTime a = LocalDateTime.now();
        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solutionPrefixSum(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("Duração: " + Duration.between(a, LocalDateTime.now()).toMillis() + "ms");
    }

    @Test
    public void testH() {
        String genome = "A";
        int[] P = {0};
        int[] Q = {0};
        int[] solution = {1};

        LocalDateTime a = LocalDateTime.now();
        Assert.assertEquals(Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(", ")),
                Arrays.stream(new GenomicRangeQuery().solutionPrefixSum(genome, P, Q)).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("Duração: " + Duration.between(a, LocalDateTime.now()).toMillis() + "ms");
    }

}
