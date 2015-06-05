package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SampleAdderTest {
    @Test
    public void testAdd() {
        List<int[][]> sampledLs = Arrays.asList(
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 1, 1, 0}, new int[]{1, 0, 1, 1, 0}},
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0}, new int[]{1, 0, 1, 0, 0}},
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 0, 1, 0}, new int[]{1, 0, 0, 1, 0}},
                new int[][]{new int[]{1, 0, 1, 0, 0, 0, 1, 0, 0}, new int[]{1, 0, 0, 0, 0}}
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4, 0, 1, 3, 0, 0, 3, 2, 0),
                Arrays.asList(4, 0, 2, 2, 0)
        );
        List<List<Integer>> result = new SampleAdder(sampledLs).add();
        assertEquals(expected, result);
    }
}