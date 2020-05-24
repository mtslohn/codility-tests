package codility.lessons;

import org.junit.Assert;
import org.junit.Test;

public class PassingCarsTest {

    private PassingCars passingCars = new PassingCars();

    private final int[] A = {0, 1, 0, 1, 1};
    private final int solutionA = 5;

    private final int[] B = {0, 1, 0, 1, 1, 1};
    private final int solutionB = 7;

    private final int[] C = {0, 1, 0, 1, 1, 0};
    private final int solutionC = 5;

    private final int[] D = {0, 1, 1, 1, 1, 1};
    private final int solutionD = 5;

    private final int[] E = {1, 1, 1, 1, 1, 1};
    private final int solutionE = 0;

    private final int[] F = {1, 0, 0, 0, 0, 0};
    private final int solutionF = 0;

    private final int[] G = {0, 1, 0, 1, 1, 0, 0};
    private final int solutionG = 5;

    @Test
    public void testA() {
        Assert.assertEquals(solutionA, passingCars.solutionA(A));
        Assert.assertEquals(solutionB, passingCars.solutionA(B));
        Assert.assertEquals(solutionC, passingCars.solutionA(C));
        Assert.assertEquals(solutionD, passingCars.solutionA(D));
        Assert.assertEquals(solutionE, passingCars.solutionA(E));
        Assert.assertEquals(solutionF, passingCars.solutionA(F));
        Assert.assertEquals(solutionG, passingCars.solutionA(G));
    }

    @Test
    public void testB() {
        Assert.assertEquals(solutionA, passingCars.solutionB(A));
        Assert.assertEquals(solutionB, passingCars.solutionB(B));
        Assert.assertEquals(solutionC, passingCars.solutionB(C));
        Assert.assertEquals(solutionD, passingCars.solutionB(D));
        Assert.assertEquals(solutionE, passingCars.solutionB(E));
        Assert.assertEquals(solutionF, passingCars.solutionB(F));
        Assert.assertEquals(solutionG, passingCars.solutionB(G));
    }

    @Test
    public void testC() {
        Assert.assertEquals(solutionF, passingCars.solutionB(F));
    }

    @Test
    public void testD() {
        Assert.assertEquals(solutionA, passingCars.solutionC(A));
        Assert.assertEquals(solutionB, passingCars.solutionC(B));
        Assert.assertEquals(solutionC, passingCars.solutionC(C));
        Assert.assertEquals(solutionD, passingCars.solutionC(D));
        Assert.assertEquals(solutionE, passingCars.solutionC(E));
        Assert.assertEquals(solutionF, passingCars.solutionC(F));
        Assert.assertEquals(solutionG, passingCars.solutionC(G));
    }


}
