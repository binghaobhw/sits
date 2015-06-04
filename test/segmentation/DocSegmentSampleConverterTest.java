package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DocSegmentSampleConverterTest {

    @Test
    public void testGetDocSegmentSamples() {
        List<Integer> docTopicShiftSamples = Arrays.asList(10, 0, 0, 2, 0, 1, 5, 2, 0);
        List<Integer> expected = Arrays.asList(0, 0, 2, 0, 1, 5, 2, 0, 10);
        List<Integer> result = new DocSegmentSampleConverter(docTopicShiftSamples).convert();
        assertEquals(expected, result);
    }
}