class Solution {
    public void rotate(int[] nums, int k) {
        
        while(k>nums.length)
        {
            k=k-nums.length;
        }
        
        if(k==0||k==nums.length)
            return;
        
        int j=0;
        int temp1=0;
        int temp2=0;
        int index=-1;
        int current=k;
        
        Map<Integer, Integer> map = new HashMap();
        
        for(int i=nums.length-k;i<nums.length;i++)
        {
            temp1 = nums[j];
            if(map.containsKey(i))
            {
                nums[j] = map.get(i);
            }
            else
            {
                nums[j] = nums[i];
            }
            
            while(current < nums.length)
            {
                temp2 = nums[current];
                index = current;
                nums[current] = temp1;
                temp1=temp2;
                current += k;
            }
            
            if(index > i)
                map.put(index, temp2);
            
            index=-1;
            
            j++;
            current=k+j;
        }
        
    }
}