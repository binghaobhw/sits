package segmentation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopPickerTest {

    @Test
    public void test2Pick() {
        List<Integer> source = Arrays.asList(10, 0, 1, 2, 1, 7, 0, 8, 1);
        int number = 2;
        List<Integer> expected = Arrays.asList(10, 8);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> result = new TopPicker<>(source, number, comparator).pick();
        assertEquals(expected, result);
    }

    @Test
    public void test3Pick() {
        List<Integer> source = Arrays.asList(10, 0, 1, 2, 1, 7, 0, 8, 1);
        int number = 3;
        List<Integer> expected = Arrays.asList(10, 8, 7);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List<Integer> result = new TopPicker<>(source, number, comparator).pick();
        assertEquals(expected, result);
    }
}