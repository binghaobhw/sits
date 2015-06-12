package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CorpusSegmentExtractorTest {

    @Test
    public void testExtract() {
        List<List<Integer>> segmentSamples = Arrays.asList(
                Arrays.asList(1, 0, 11, 5, 3, 0, 2, 20),
                Arrays.asList(0, 5, 3, 0, 5, 10)
        );
        List<Integer> segmentNums = Arrays.asList(3, 2);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 3, 7),
                Arrays.asList(1, 5)
        );
        List<List<Integer>> result = new CorpusSegmentExtractor(segmentSamples, segmentNums).extract();
        assertEquals(expected, result);
    }
}