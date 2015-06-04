package segmentation;

import java.util.ArrayList;
import java.util.List;

public class SampleAdder {
    private final List<int[][]> samples;

    public SampleAdder(final List<int[][]> samples) {
        this.samples = samples;
    }

    public List<List<Integer>> add() {
        List<List<Integer>> addedSamples = new ArrayList<>();
        if (samples == null || samples.size() == 0) {
            return new ArrayList<>();
        }
        int[][] samplesFirstIteration = samples.get(0);
        int i;
        for (i = 0; i < samplesFirstIteration.length; i++) {
            int[] samplesInDoc = samplesFirstIteration[i];

            List<Integer> zeroes = new ArrayList<>(samplesInDoc.length);
            for (int j = 0; j < samplesInDoc.length; j++) {
                zeroes.add(0);
            }
            addedSamples.add(zeroes);
        }
        for (int[][] samplesPerIteration : samples) {
            for (i = 0; i < samplesPerIteration.length; i++) {
                int[] topicShiftInDoc = samplesPerIteration[i];
                List<Integer> addedSamplesInDoc = addedSamples.get(i);
                for (int j = 0; j < topicShiftInDoc.length; j++) {
                    addedSamplesInDoc.set(j, addedSamplesInDoc.get(j) + topicShiftInDoc[j]);
                }
            }
        }
        return addedSamples;
    }
}
