package segmentation;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class DocSegmentWriter {
    private final Writer writer;
    private final List<Integer> segments;
    private final String name;

    public DocSegmentWriter(final Writer writer, final List<Integer> segments, final String name) {
        this.writer = writer;
        this.segments = segments;
        this.name = name;
    }

    public void write() throws IOException {
        int segmentNum = segments.size();
        int lineTotal = segments.get(segmentNum - 1) + 1;
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" ");
        builder.append(lineTotal);
        builder.append(" ");
        builder.append(segmentNum);
        builder.append(" ");
        for (int i = 0; i < segmentNum; i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(segments.get(i));
        }
        builder.append("\n");
        writer.write(builder.toString());
    }
}
