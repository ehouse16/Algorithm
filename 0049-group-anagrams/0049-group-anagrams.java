import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> sortedList = new ArrayList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            int check = -1;
            for (int i = 0; i < sortedList.size(); i++) {
                if (sortedList.get(i).equals(sortedStr)) {
                    check = i;
                    break;
                }
            }

            if (check == -1) {
                sortedList.add(sortedStr);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
            } else {
                result.get(check).add(str);
            }
        }

        return result;
    }
}
