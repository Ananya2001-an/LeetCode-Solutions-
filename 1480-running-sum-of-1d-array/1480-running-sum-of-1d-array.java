class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSums = new int[nums.length];
        
        int prevSum = 0;
        for(int i=0;i<nums.length;i++){
            runningSums[i] = prevSum + nums[i];
            prevSum = runningSums[i];
        }
        
        return runningSums;
    }
}