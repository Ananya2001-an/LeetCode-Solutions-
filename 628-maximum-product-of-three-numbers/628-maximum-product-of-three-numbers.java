class Solution {
    public int maximumProduct(int[] nums) {
        int prod=1;
        if(nums.length == 3)
        {
            prod = nums[0] * nums[1] * nums[2];
        }
        
        Arrays.sort(nums);
        
        if( nums[nums.length-1]==0 ||  nums[nums.length-2]==0 ||  nums[nums.length-3]==0)
        {
            prod=0;
        }
        
        if (nums[0]<0 && nums[1]<0 && nums[nums.length-1]>0)
        {
            int p1 =  nums[0] * nums[1] * nums[nums.length-1];
            int p2 =  nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
            
            if(p1 > p2)
                prod = p1;
            else
                prod = p2;
        }
        
        if(nums[0]<0 && nums[1]>=0 || nums[0]>=0 || nums[nums.length-1]<0)
        {
            prod = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        }
        
        
        return prod;
    }
}