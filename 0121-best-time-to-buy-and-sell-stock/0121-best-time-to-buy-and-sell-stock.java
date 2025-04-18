class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        int length = prices.length;

        for(int i = 1; i < length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}