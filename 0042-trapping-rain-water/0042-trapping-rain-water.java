class Solution {
    public int trap(int[] height) {
        int length = height.length;

        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        int sum = 0;

        //왼쪽 최고 높이 구하기
        leftMax[0] = height[0];
        for(int i = 1; i < length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //오른쪽 최고 높이 구하기
        rightMax[length-1] = height[length-1]; 
        for(int j = length-2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        //각 위치의 고인 물 더하기
        for(int a = 0; a < length; a++){  
            sum += Math.min(leftMax[a], rightMax[a]) - height[a]; 
        }

        return sum;
    }
}