class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       
        Map<Integer, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(nums1.length >= nums2.length)
        {
            int i=0;
            int j=nums1.length-1;
            
            while(i<=j)
            {
                if(map.containsKey(nums1[i]) == false)
                    map.put(nums1[i], 0);
                if(map.containsKey(nums1[j]) == false)
                    map.put(nums1[j], 0);
                i++;
                j--;
            }
            
            for(int k=0;k<nums2.length;k++)
            {
                if(map.containsKey(nums2[k]))
                    list.add(nums2[k]);
            }
             
        }
        
        else
        {
            int i=0;
            int j=nums2.length-1;
            
            while(i<=j)
            {
                if(map.containsKey(nums2[i]) == false)
                    map.put(nums2[i], 0);
                if(map.containsKey(nums2[j]) == false)
                    map.put(nums2[j], 0);
                i++;
                j--;
            }
            
            for(int k=0;k<nums1.length;k++)
            {
                if(map.containsKey(nums1[k]))
                    list.add(nums1[k]);
            }
            
        }
        
        List<Integer> uniqueList
            = list.stream().distinct().collect(
                Collectors.toList());
        
        int[] intersect = new int[uniqueList.size()];
        for(int i=0;i<intersect.length;i++)
        {
            intersect[i] = uniqueList.get(i);
        }
        
        return intersect;
    }
}