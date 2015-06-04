package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CorpusSegmentSampleConverterTest {

    @Test
    public void testGetSegmentSamples1() {
        List<List<Integer>> topicShiftSamples = Arrays.asList(
                Arrays.asList(10, 0, 0, 2, 0, 1, 5, 2, 0),
                Arrays.asList(10, 0, 2, 0, 5, 2, 1)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0, 2, 0, 1, 5, 2, 0, 10),
                Arrays.asList(0, 2, 0, 5, 2, 1, 10)
        );
        List<List<Integer>> result = new CorpusSegmentSampleConverter(topicShiftSamples).convert();
        assertEquals(expected, result);
    }

    @Test
    public void testGetSegmentSamples2() {
        List<List<Integer>> topicShiftSamples = Arrays.asList(
                Arrays.asList(4, 0, 1, 3, 0, 0, 3, 2, 0),
                Arrays.asList(4, 0, 2, 2, 0)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1, 3, 0, 0, 3, 2, 0, 4),
                Arrays.asList(0, 2, 2, 0, 4)
        );
        List<List<Integer>> result = new CorpusSegmentSampleConverter(topicShiftSamples).convert();
        assertEquals(expected, result);
    }
}