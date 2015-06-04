package segmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SegmentNumReader {
    private final BufferedReader reader;

    public SegmentNumReader(final BufferedReader reader) {
        this.reader = reader;
    }

    public List<Integer> read() throws IOException {
        List<Integer> segmentNums = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            segmentNums.add(Integer.parseInt(line));
        }
        return segmentNums;
    }
}
