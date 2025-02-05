class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            Integer j = result.get(target - nums[i]);

            if(j == null)
                result.put(nums[i], i);
            else
                return new int[]{i,j};
        }
        return new int[]{-1,-1};
    }
}