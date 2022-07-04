class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1)
        {
            return 0;
        }
        
        int left_sum_1 = 0;
        int right_sum_1 = Arrays.stream(nums).sum() - nums[0];
        
        if (left_sum_1 == right_sum_1)
        {
            return 0;
        }
        
        int left_sum_2 = Arrays.stream(nums).sum() - nums[nums.length-1];
        int right_sum_2 = 0;
        Integer sum = null; 
        int index = 0;
        
        if(left_sum_2 == right_sum_2)
        {
            sum = left_sum_2;
            index = nums.length-1;
        }
        
        int i = 1;
        int j = nums.length-2;
        
        
        while(i<=j)
        {
            left_sum_1+=nums[i-1];
            right_sum_1-=nums[i];
            if(left_sum_1 == right_sum_1)
            {
                return i;
            }
            
            
            left_sum_2-=nums[j];
            right_sum_2+=nums[j+1];
            if(left_sum_2 == right_sum_2)
            {
                sum = left_sum_2;
                index = j;
            }
            
            i++;
            j--;
        }
        
        if(sum != null)
        {
            return index;
        }
        
        return -1;
    }
}