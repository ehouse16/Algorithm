class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        int sum = 0;

        for(int i = 0; i < length - 1; i+=2){
            sum += Math.min(nums[i], nums[i+1]);
        }
        
        return sum;
    }
}