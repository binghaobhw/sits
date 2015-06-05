package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DocNameConverterTest {

    @Test
    public void testConvert() {
        String[] conversationNames = new String[]{"a", "a", "a", "", "b", "", "c", "c", ""};
        List<String> expected = Arrays.asList("a", "b", "c");
        List<String> result = new DocNameConverter(conversationNames).convert();
        assertEquals(expected, result);
    }
}