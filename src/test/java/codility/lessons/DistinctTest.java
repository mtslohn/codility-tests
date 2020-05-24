package codility.lessons;

import org.junit.Assert;
import org.junit.Test;

public class DistinctTest {

    private Distinct distinct = new Distinct();

    private int[] A = {2, 1, 1, 2, 3, 1};
    private int solA = 3;

    private int[] zeroLength = {};
    private int solZeroLength = 0;

    private int[] oneLength = {2};
    private int solOneLength = 1;

    private int[] allTheSame = {2, 2, 2, 2, 2};
    private int solAllTheSame = 1;

    @Test
    public void testA() {
        Assert.assertEquals(solA, distinct.solution(A));
    }

    @Test
    public void testZeroLength() {
        Assert.assertEquals(solZeroLength, distinct.solution(zeroLength));
    }

    @Test
    public void testOneLength() {
        Assert.assertEquals(solOneLength, distinct.solution(oneLength));
    }

    @Test
    public void testAllTheSame() {
        Assert.assertEquals(solAllTheSame, distinct.solution(allTheSame));
    }

}
