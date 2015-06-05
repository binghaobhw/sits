package segmentation;


import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class IndexValuePairs<T> {
    private final List<T> source;

    public IndexValuePairs(final List<T> source) {
        this.source = source;
    }

    public List<Entry<Integer, T>> getPairs() {
        List<Entry<Integer, T>> pairs = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            pairs.add(new SimpleImmutableEntry<>(i, source.get(i)));
        }
        return pairs;
    }
}
