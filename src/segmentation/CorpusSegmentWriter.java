package segmentation;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CorpusSegmentWriter {
    private final Writer writer;
    private final List<List<Integer>> segments;
    private final List<String> names;

    public CorpusSegmentWriter(Writer writer, List<List<Integer>> segments, List<String> names) {
        this.writer = writer;
        this.segments = segments;
        this.names = names;
    }

    public void write() throws IOException {
        for (int i = 0; i < segments.size(); i++) {
            new DocSegmentWriter(writer, segments.get(i), names.get(i)).write();
        }
    }
}

