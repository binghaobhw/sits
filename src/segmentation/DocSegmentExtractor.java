package segmentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

public class DocSegmentExtractor {
    private final List<Integer> segmentSamples;
    private final int segmentNum;

    public DocSegmentExtractor(List<Integer> segmentSamples, int segmentNum) {
        this.segmentSamples = segmentSamples;
        this.segmentNum = segmentNum;
    }

    public List<Integer> extract() {
        if (segmentNum > segmentSamples.size()) {
            return new ArrayList<>();
        }
        int lastIndex = segmentSamples.size() - 1;
        List<Entry<Integer, Integer>> tops = new TopPicker<>(
                new IndexValuePairs<>(segmentSamples.subList(0, lastIndex)).getPairs(),
                segmentNum - 1,
                new Comparator<Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                }
        ).pick();
        Collections.sort(tops, new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        List<Integer> segments = new ArrayList<>();
        for (Entry<Integer, Integer> entry : tops) {
            segments.add(entry.getKey());
        }
        segments.add(lastIndex);
        return segments;
    }
}
