package segmentation;

import java.util.ArrayList;
import java.util.List;

public class DocNameConverter {
    private final String[] conversationNames;

    public DocNameConverter(final String[] conversationNames) {
        this.conversationNames = conversationNames;
    }

    public List<String> convert() {
        List<String> docNames = new ArrayList<>();
        String previousName = "";
        for (String name : conversationNames) {
            if (name.equalsIgnoreCase("")) {
                docNames.add(previousName);
            }
            previousName = name;
        }
        return docNames;
    }
}
