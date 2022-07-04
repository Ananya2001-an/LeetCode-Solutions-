class Solution {
    public int majorityElement(int[] nums) {
        int limit = (int)Math.floor(nums.length / 2);
        int majElement = 0;
        
        Arrays.sort(nums);
        int current_element = nums[0];
        int count = 1;
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == current_element)
                count++;
            else
            {
                
                if(count > limit)
                {
                    majElement = current_element;
                    break;
                }
                else
                {
                    current_element = nums[i];
                    count = 1; 
                }
            }
        }
        
        if(count > limit)
            majElement = current_element;
        
        return majElement;
        
        
    }
}