package segmentation;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocSegmentWriter {
    private final Writer writer;
    /**
     * segments[i] = index of last sent in i-th segment
     */
    private final List<Integer> segments;
    private final String name;

    public DocSegmentWriter(final Writer writer, final List<Integer> segments, final String name) {
        this.writer = writer;
        this.segments = segments;
        this.name = name;
    }

    public void write() throws IOException {
        int segmentNum = segments.size();
        // Also index of the last sent
        int gapCount = segments.get(segmentNum - 1);
        int lastSegmentIndex = segmentNum - 1;
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"id\":\"").append(name).append("\"");
        builder.append(",");
        builder.append("\"gapCount\":").append(gapCount);
        builder.append(",");
        Stream<String> boundaryIndices = segments.subList(0, lastSegmentIndex).stream().map(i -> String.valueOf(i + 1));
        builder.append("\"boundaryIndices\":").append(boundaryIndices.collect(Collectors.joining(",", "[", "]")));
        builder.append("}");
        builder.append("\n");
        writer.write(builder.toString());
    }
}
