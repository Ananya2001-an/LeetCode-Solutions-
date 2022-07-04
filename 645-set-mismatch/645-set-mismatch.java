class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        
        if(nums.length == 2)
        {
            if(nums[0] == 1)
            {
                arr[0] = 1;
                arr[1] = 2;
                return arr;
            }
            else
            {
                arr[0] = 2;
                arr[1] = 1;
                return arr;
            }
        }
        
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap();
        
        boolean repeat_found = false;
        boolean missing_found = false;
        
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                arr[0] = nums[i];
                repeat_found = true;
            }
            else
            {
                if(map.containsKey(nums[i]-1) == false && nums[i]-1>0)
                {
                    arr[1] = nums[i]-1;
                    missing_found = true;
                }
                map.put(nums[i], 1);
            } 
            
            if(repeat_found == true && missing_found == true)
                break;
            
        }
        
        if(missing_found != true)
            arr[1] = nums.length;
        
        return arr;
    }
}