class Solution {
    public boolean isPalindrome(String s) {
        String s2 = s.toLowerCase().trim();

        String word = "";

        for(int i = 0; i < s2.length(); i++){
            if(Character.isLetterOrDigit(s2.charAt(i)))
                word+=s2.charAt(i);
        }

        //System.out.println(word);

        for(int j = 0; j < word.length(); j++){
            if(word.charAt(j)!=word.charAt(word.length()-1-j))
                return false;
        }
        return true;
    }
}