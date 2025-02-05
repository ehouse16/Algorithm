class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        int start = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = start; i < start + max; i++) {
            answer.append(s.charAt(i));
        }
        
        return answer.toString();
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        for (int j = left; j <= (left + right) / 2; j++) {
            if (s.charAt(j) != s.charAt(right - (j - left))) {
                return false;
            }
        }
        return true;
    }
}