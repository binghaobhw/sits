package segmentation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TopPicker<T> {
    private final List<T> source;
    private final int number;
    private final Comparator<T> comparator;

    public TopPicker(final List<T> source, final int number, final Comparator<T> comparator) {
        if (source != null && number > source.size()) {
            throw new IllegalArgumentException("number must <= source.length");
        }
        this.source = source;
        this.number = number;
        this.comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return -(comparator.compare(o1, o2));
            }
        };
    }

    public List<T> pick() {
        if (source == null || source.size() == 0 || number == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<T> minHeap = new PriorityQueue<>(number, comparator);
        for (T i : source) {
            minHeap.add(i);
        }
        List<T> out = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            out.add(minHeap.poll());
        }
        return out;
    }
}
