package codility.lessons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinAvgTwoSliceTest {

    private MinAvgTwoSlice minAvgTwoSlice;
    private int[] A = {4, 2, 2, 5, 1, 5, 8}; // 1
    private int[] B = {-3, -5, -8, -4, -10}; // 2
    private int[] C = {5, 6, 3, 4, 9}; // 2
    private int[] D = {5, 8, 4, 2, 5, 5, 7, 8, 6, 8}; // 2
    private int[] E = {1, 0, -1, 1, 1, -1, -1, 1, 1, -1, 0, 0, -1, -1, 0, 1, 1, -1, 0, 0, 0, -1, -1, -1, 0, 0, -1, 1, 1, 1, 1, -1, -1, 0, 1, 0, 1, -1, 1, 0, 0, 1, 0, -1, 0, 0, 0, 1, 1, -1, 1, 0, -1, -1, -1, 1, -1, 1, -1, -1, 0, 0, 1, -1, 0, 0, -1, 1, 1, 0, -1, 0, 0, 0, -1, 1, -1, -1, -1, 0, 0, -1, 0, 1, -1, 1, 0, 0, -1, 0, -1, 1, 1, 0, 1, 1, 1, 1, -1, 0, 1, 1, 0, 0, 1, 1, 0, -1, -1, 1, 1, 1, 1, -1, 0, 1, 0, -1, -1, 0, 1, 0, 1, -1, 0, 0, -1, 1, -1, -1, -1, 0, -1, 1, 0, 0, 1, 0, 1, 0, 0, -1, -1, 0, 1, 0, 1, 0, 0, -1, 0, 0, 0, 1, 0, -1, -1, 0, 0, -1, -1, 1, -1, 1, -1, 1, -1, 0, 1, -1, 0, 0, -1, 0, 0, 0, -1, 0, 0, 1, 0, -1, 0, 1, -1, 0, 0, -1, -1, 0, 1, 0, -1, 0, 1, 1, 0, 0, -1, 0, -1, 0, 0, 0, -1, 1, 1, -1, -1, -1, 1, 1, 1, 0, 1, -1, 1, 1, 1, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 1, 0, -1, -1, 1, -1, 1, -1, 1, 1, 0, 1, 0, 0, 0, -1, 1, 1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 0, 0, 1, 1, -1, -1, -1, -1, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, -1, 0, 1, 0, 0, 1, -1, -1, -1, -1, 1, 1, 1, -1, 0, 1, -1, -1, 0, 0, 1, -1, -1, -1, 0, -1, 1, 1, 1, 1, -1, 0, 1, 1, 0, -1, 0, 0, 1, 0, 0, 0, 0, 1, 1, -1, 1, 1, 0, 1, 1, 0, 1, 1, 1, -1, 1, 1, -1, -1, -1, 0, 1, 0, 0, 1, -1, -1, 0, -1, -1, 0, 1, 0, 0, 1, 0, -1, 1, -1, 0, 0, 0, 0, -1, 0, -1, 1, 1, 0, 0, -1, 1, 0, 1, -1, 0, -1, 1, 0, 0, -1, -1, 1, 0, -1, -1, 0, -1, 0, 0, -1, 1, -1, 1, -1, -1, 1, -1, -1, -1, 0, 1, 0, 0, -1, -1, -1, -1, 0, 0, 1, 0, -1, 1, -1, -1, 1, 0, 0, 1, -1, 1, 1, 0, 0, 0, 1, 0, -1, 1, 1, 0, 1, 1, -1, 0, 0, -1, -1, -1, 1, 0, 1, 1, 1, 0, -1, 0, 0, -1, -1, 1, -1, 1, -1, 1, 1, 0, -1, 0, -1, 1, 1, 1, -1, 1, 1, 0, 0, 1, -1, 1, -1, -1, 0, 1, -1, 0, 1, 0, 1, 1, 0, 0, -1, -1, 1, 0, 0, 0, 1, 1, 0, 1, -1, 1, 0, -1, 0, 1, 0, 1, 1, 0, -1, 0, -1, 0, 1, -1, 0, 0, 0, -1, -1, -1, 1, 1, 1, -1, -1, 0, -1, 1, 0, 0, 0, 1, 0, 0, 1, -1, 0, 1, 1, 1, 1, -1, -1, 0, 0, -1, 0, 0, -1, -1, 0, 1, 1, 1, 1, -1, 0, 1, 1, 1, 0, 0, 1, -1, 1, 0, -1, 1, 0, 1, 0, 0, 1, -1, 0, -1, 0, -1, -1, -1, 1, -1, 0, -1, 0, 1, 0, 0, 1, 0, 0, 0, 1, -1, 0, 0, 1, -1, -1, -1, 0, 0, 0, 1, 1, 1, 0, -1, -1, -1, -1, 1, -1, -1, 1, -1, -1, 1, 0, -1, -1, 0, 1, -1, -1, -1, -1, -1, 1, 0, 0, -1, -1, -1, -1, 1, -1, 0, 0, -1, -1, -1, -1, 1, 1, 1, 0, -1, 1, 1, 0, -1, 1, 0, 0, 1, 0, -1, 0, 1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, 0, -1, 0, 1, -1, 0, 1, -1, 0, 0, 0, 1, 1, -1, 1, -1, 1, 0, 0, -1, -1, 0, 1, 1, 1, -1, 0, -1, 0, 0, -1, 1, 0, 1, 0, 0, -1, 0, 0, -1, -1, -1, 0, 1, 1, -1, -1, 1, 0, 1, -1, 1, 1, -1, -1, 0, 0, 1, 0, -1, 0, 1, 0, 1, 1, 1, -1, 1, 0, 1, -1, -1, 1, -1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, -1, 1, 0, 0, 0, 0, 0, 0, 1, 1, -1, 0, 0, -1, 1, 1, 1, -1, 1, -1, 1, 0, 0, 1, 1, 1, 1, -1, -1, -1, -1, 1, 0, 1, -1, 0, -1, -1, 0, 1, 1, -1, 1, -1, 0, -1, -1, 0, 0, -1, -1, 0, 1, 0, -1, 0, 0, 0, -1, 1, 0, 1, 1, 0, 0, -1, 1, 1, -1, 0, 1, 0, 1, 1, 0, -1, 0, 1, 1, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1, -1, -1, 1, 0, -1, 0, -1, -1, -1, 1, 0, -1, 1, 0, -1, -1, 0, -1, -1, 0, -1, 1, 0, 1, 1, 1, 1, 0, 1, -1, 1, 1, -1, -1, 0, -1, -1, 0, 0, -1, 1, -1, -1, 1, 1, 1, 0, 0, 0, 1, 1, 1, -1, 1, 0, 0, 0, -1, 1, -1, -1, 0, 0, 0, 1, 1, 1, 0, -1, 0, 0, 0, 1, -1, 0, -1, -1, 0, 0, -1, 1, 1, 1, 1, 0, 0, 0, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, 1, 1, -1, -1, 1, 1, 1, -1, 0, -1, 1, 1, -1, -1, 1, 1, -1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, -1, 1, 0, 0, 1, -1, 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 1, 1, 1}; // 5

    @Before
    public void setup() {
        minAvgTwoSlice = new MinAvgTwoSlice();

        /*A = new int[7];
        A[0] = 4;
        A[1] = 2;
        A[2] = 2;
        A[3] = 5;
        A[4] = 1;
        A[5] = 5;
        A[6] = 8;*/
    }

    @Test
    public void generateArray() {
        int[] array = IntStream.generate(() -> ((int) (Math.random() * 3)) - 1).limit(1000).toArray();

        int expect = minAvgTwoSlice.secondSolution(array);
        System.out.println("{" +
                Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", ")) +
                "}");

        System.out.println("Expect: " + expect);
    }

    @Test
    public void testA() {
        Assert.assertEquals(1, minAvgTwoSlice.firstSolution(A));
    }

    @Test
    public void testB() {
        Assert.assertEquals(2, minAvgTwoSlice.firstSolution(B));
    }

    @Test
    public void testC() {
        Assert.assertEquals(1, minAvgTwoSlice.secondSolution(A));
    }

    @Test
    public void testD() {
        Assert.assertEquals(2, minAvgTwoSlice.secondSolution(B));
    }

    @Test
    public void testE() {
        Assert.assertEquals(1, minAvgTwoSlice.thirdSolution(A));
    }

    @Test
    public void testF() {
        Assert.assertEquals(2, minAvgTwoSlice.thirdSolution(B));
    }

    @Test
    public void testG() {
        Assert.assertEquals("A", 1, minAvgTwoSlice.thirdSolution(A));
        Assert.assertEquals("B", 2, minAvgTwoSlice.thirdSolution(B));
        Assert.assertEquals("C", 2, minAvgTwoSlice.thirdSolution(C));
        Assert.assertEquals("D", 2, minAvgTwoSlice.thirdSolution(D));
        Assert.assertEquals("E", 5, minAvgTwoSlice.thirdSolution(E));
    }

    @Test
    public void testH() {
        Assert.assertEquals("E", 5, minAvgTwoSlice.thirdSolution(E));
    }

}
