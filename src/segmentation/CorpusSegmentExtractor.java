package segmentation;

import java.util.ArrayList;
import java.util.List;

public class CorpusSegmentExtractor {
    private final List<List<Integer>> segmentSamples;
    private final List<Integer> segmentNums;

    public CorpusSegmentExtractor(List<List<Integer>> segmentSamples, List<Integer> segmentNums) {
        this.segmentSamples = segmentSamples;
        this.segmentNums = segmentNums;
    }

    public List<List<Integer>> extract() {
        List<List<Integer>> segments = new ArrayList<>(segmentSamples.size());
        for (int i = 0; i < segmentSamples.size(); i++) {
            segments.add(new DocSegmentExtractor(segmentSamples.get(i), segmentNums.get(i)).extract());
        }
        return segments;
    }
}
