package segmentation;

import org.junit.Test;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import static org.junit.Assert.*;

public class IndexValuePairsTest {

    @Test
    public void testGetPairs_integer() {
        List<Integer> source = Arrays.asList(9, 8, 7, 6, 5);
        List<Entry<Integer, Integer>> expected = new ArrayList<>();
        expected.add(new SimpleImmutableEntry<>(0, 9));
        expected.add(new SimpleImmutableEntry<>(1, 8));
        expected.add(new SimpleImmutableEntry<>(2, 7));
        expected.add(new SimpleImmutableEntry<>(3, 6));
        expected.add(new SimpleImmutableEntry<>(4, 5));
        List<Entry<Integer, Integer>> result = new IndexValuePairs<>(source).getPairs();
        assertEquals(expected, result);
    }

    @Test
    public void testGetPairs_string() {
        List<String> source = Arrays.asList("9", "8", "7", "6", "5");
        List<Entry<Integer, String>> expected = new ArrayList<>();
        expected.add(new SimpleImmutableEntry<>(0, "9"));
        expected.add(new SimpleImmutableEntry<>(1, "8"));
        expected.add(new SimpleImmutableEntry<>(2, "7"));
        expected.add(new SimpleImmutableEntry<>(3, "6"));
        expected.add(new SimpleImmutableEntry<>(4, "5"));
        List<Entry<Integer, String>> result = new IndexValuePairs<>(source).getPairs();
        assertEquals(expected, result);
    }
}