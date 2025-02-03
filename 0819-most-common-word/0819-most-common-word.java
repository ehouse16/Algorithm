import java.util.HashMap;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();

        String[] normal = words.split("\\s+");
        
        HashMap<String, Integer> split = new HashMap();

        for (String word: normal) {
            boolean isBanned = false;
            for (String ban : banned) {
                if (ban.equals(word)) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned) {
                split.put(word, split.getOrDefault(word, 0) + 1);
            }
        }
    
        String mostCommon = "";
        int max = 0;

        for (HashMap.Entry<String, Integer> entry : split.entrySet()) {
            if (entry.getValue() > max) {
                mostCommon = entry.getKey();
                max = entry.getValue();
            }
        }

        return mostCommon;
    }
}