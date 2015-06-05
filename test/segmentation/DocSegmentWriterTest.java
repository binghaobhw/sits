package segmentation;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DocSegmentWriterTest {

    @Test
    public void testWrite() throws IOException {
        Writer writer = new StringWriter();
        List<Integer> segments = Arrays.asList(5, 10, 15);
        String name = "a";
        String expected = "a 16 3 5,10,15\n";
        new DocSegmentWriter(writer, segments, name).write();
        assertEquals(expected, writer.toString());
    }
}