package segmentation;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TopicSegmentationTest {

    @Test
    public void testOutputSegment() throws IOException {
        TopicSegmentation topicSegmentation = new TopicSegmentation();
        topicSegmentation.conversation_names = new String[]{
                "a", "a", "a", "a", "a", "a", "a", "a", "a",
                "",
                "b", "b", "b", "b", "b",
                ""
        };
        topicSegmentation.segmentNums = Arrays.asList(3, 2);
        List<int[][]> sampledLs = Arrays.asList(
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 1, 1, 0}, new int[]{1, 0, 1, 1, 0}},
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0}, new int[]{1, 0, 1, 0, 0}},
                new int[][]{new int[]{1, 0, 0, 1, 0, 0, 0, 1, 0}, new int[]{1, 0, 0, 1, 0}},
                new int[][]{new int[]{1, 0, 1, 0, 0, 0, 1, 0, 0}, new int[]{1, 0, 0, 0, 0}}
        );
        String expected = "a 9 3 2,5,8\n" +
                "b 5 2 1,4\n";
        Writer writer = new StringWriter();
        topicSegmentation.outputSegment(writer, sampledLs);
        assertEquals(expected, writer.toString());
    }
}