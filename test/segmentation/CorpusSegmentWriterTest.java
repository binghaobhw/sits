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
        List<List<Integer>> segments = Arrays.asList(
                Arrays.asList(2, 5, 8),
                Arrays.asList(0, 2, 4)
        );
        List<String> names = Arrays.asList("a", "b");
        String expected = "a 9 3 2,5,8\n" +
                "b 5 3 0,2,4\n";
        new CorpusSegmentWriter(writer, segments, names).write();
        assertEquals(expected, writer.toString());
    }
}