class Solution {
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap();
        Map<Integer, Integer> first_index = new HashMap();
        Map<Integer, Integer> second_index = new HashMap();
        
        for(int i=0;i<nums.length;i++)
        {
            if(freq.containsKey(nums[i]))
            {
                //increment value by one in freq and update second_index
                
                freq.put(nums[i], freq.get(nums[i]) + 1);
                second_index.put(nums[i], i);
            }
            else
            {
                freq.put(nums[i], 1);
                first_index.put(nums[i], i);
                second_index.put(nums[i], i);
            }
        }
        
        int degree = Collections.max(freq.values());
        
        Integer[] keys = new Integer[freq.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == degree) {
                keys[k] = entry.getKey();
                k++;
            }
        }
        
        int smallest_subarray_len = nums.length;
        
        for(int j=0;j<keys.length;j++)
        {
            if(keys[j] != null)
            {
        
            int diff = second_index.get(keys[j]) - first_index.get(keys[j]) + 1;
            if(diff < smallest_subarray_len)
            {
                smallest_subarray_len = diff;
            }
                
            }
        }
        
        return smallest_subarray_len;
    }
}