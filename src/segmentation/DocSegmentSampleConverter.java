package segmentation;

import java.util.ArrayList;
import java.util.List;

public class DocSegmentSampleConverter {
    private final List<Integer> topicShiftSamples;

    public DocSegmentSampleConverter(final List<Integer> topicShiftSamples) {
        this.topicShiftSamples = topicShiftSamples;
    }

    public List<Integer> convert() {
        List<Integer> docSegmentSamples = new ArrayList<>(topicShiftSamples.size());
        for (int i = 1; i < topicShiftSamples.size(); i++) {
            docSegmentSamples.add(topicShiftSamples.get(i));
        }
        docSegmentSamples.add(topicShiftSamples.get(0));
        return docSegmentSamples;
    }
}
