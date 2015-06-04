package segmentation;

import java.util.ArrayList;
import java.util.List;

public class CorpusSegmentSampleConverter {
    private final List<List<Integer>> topicShiftSamples;

    public CorpusSegmentSampleConverter(final List<List<Integer>> topicShiftSamples) {
        this.topicShiftSamples = topicShiftSamples;
    }

    public List<List<Integer>> convert() {
        List<List<Integer>> segmentSamples = new ArrayList<>(topicShiftSamples.size());
        for (int i = 0; i < topicShiftSamples.size(); i++) {
            List<Integer> docShiftSamples = topicShiftSamples.get(i);
            List<Integer> docSegmentSamples = new DocSegmentSampleConverter(docShiftSamples).convert();
            segmentSamples.add(docSegmentSamples);
        }
        return segmentSamples;
    }
}
