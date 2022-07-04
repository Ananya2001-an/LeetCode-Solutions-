class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if(k == nums.length)
            return nums;
        Map<Integer, Integer> map = new HashMap();
        
        int[] nums_org = nums.clone();
        Arrays.sort(nums);
        int p=k;
        
        for(int i=nums.length-1;i>=0;i--)
        {
            if(map.containsKey(nums[i]) == false)
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
            p--;
            if(p==0)
                break;
        }
        
        int[] subs = new int[k];
        int j=0;
        
        for(int i=0;i<nums_org.length;i++)
        {
           if(map.containsKey(nums_org[i]) && map.get(nums_org[i])>0)
           {
               subs[j] = nums_org[i];
               j++;
               map.put(nums_org[i], map.get(nums_org[i])-1);
           }
        }
        
        return subs;
    }
}