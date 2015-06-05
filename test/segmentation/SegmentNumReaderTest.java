package segmentation;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SegmentNumReaderTest {

    @Test
    public void testRead() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("5\n2\n10\n1\n"));
        List<Integer> expected = Arrays.asList(5, 2, 10, 1);
        List<Integer> result = new SegmentNumReader(reader).read();
        assertEquals(expected, result);
    }
}