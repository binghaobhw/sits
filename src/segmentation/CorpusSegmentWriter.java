package segmentation;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

public class CorpusSegmentWriter {
    private final Writer writer;
    private final List<Integer> segmentNums;
    private final List<int[][]> sampledLs;
    private final List<String> docNames;

    public CorpusSegmentWriter(final Writer writer, final List<Integer> segmentNums, final List<int[][]> sampledLs, final List<String> docNames) {
        this.writer = writer;
        this.segmentNums = segmentNums;
        this.sampledLs = sampledLs;
        this.docNames = docNames;
    }

    public void write() throws IOException {
        List<List<Integer>> addedSegmentSamples = new CorpusSegmentSampleConverter(
                new SampleAdder(sampledLs).add()
        ).convert();
        for (int i = 0; i < addedSegmentSamples.size(); i++) {
            List<Integer> samplesInDoc = addedSegmentSamples.get(i);
            List<Entry<Integer, Integer>> tops = new TopPicker<>(
                    new IndexValuePairs<>(samplesInDoc).getPairs(),
                    segmentNums.get(i),
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
            List<Integer> docSegments = new ArrayList<>(tops.size());
            for (Entry<Integer, Integer> entry : tops) {
                docSegments.add(entry.getKey());
            }
            new DocSegmentWriter(writer, docSegments, docNames.get(i)).write();
        }
    }
}
