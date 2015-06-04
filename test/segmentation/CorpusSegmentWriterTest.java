package segmentation;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CorpusSegmentWriterTest {

    @Test
    public void testWrite() throws IOException {
        Writer writer = new StringWriter();
        List<Integer> segmentNums = Arrays.asList(3, 2);
        List<int[][]> sampledLs = Arrays.asList(
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 1, 1, 0}, new int[]{1, 0, 1, 1, 0}},
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0}, new int[]{1, 0, 1, 0, 0}},
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 0, 1, 0}, new int[]{1, 0, 0, 1, 0}},
                new int[][]{new int[]{1, 0, 1, 0, 0, 0, 1, 0, 0}, new int[]{1, 0, 0, 0, 0}}
        );
        List<String> docNames = Arrays.asList("a", "b");
        String expected = "a 9 3 2,5,8\n" +
                "b 5 2 1,4\n";
        new CorpusSegmentWriter(writer, segmentNums, sampledLs, docNames).write();
        assertEquals(expected, writer.toString());
    }
}