package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DocSegmentExtractorTest {

    @Test
    public void testExtract() {
        List<Integer> segmentSamples = Arrays.asList(0, 1, 1, 5, 6, 5, 0, 10);
        int segmentNum = 3;
        List<Integer> expected = Arrays.asList(3, 4, 7);
        List<Integer> result = new DocSegmentExtractor(segmentSamples, segmentNum).extract();
        assertEquals(expected, result);
    }
}