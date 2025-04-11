class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        int num = 1;
        for(int i = 0; i < length; i++){
            answer[i] = num;
            num *= nums[i];
        }

        int num2 = 1;
        for(int j = length - 1; j >= 0; j--){
            answer[j] *= num2;
            num2 *= nums[j];
        }
        return answer;
    }
}