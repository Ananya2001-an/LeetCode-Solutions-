class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] common_list = new String[Math.min(list1.length, list2.length)];
        int k = 0;
        Integer index_sum = null;
        
        Map<String, Integer> map = new HashMap();
        
        if(list1.length <= list2.length)
        {
            for(int i=0;i<list1.length;i++)
            {
                map.put(list1[i], i);
            }
            
            for(int j=0;j<list2.length;j++)
            {
                if(map.containsKey(list2[j]))
                {
                    int sum = map.get(list2[j]) + j;
                    if(index_sum == null)
                    {
                        index_sum = sum;
                        common_list[k] = list2[j];
                        k++;
                    }
                    else if(index_sum == sum)
                    {
                        common_list[k] = list2[j];
                        k++;
                    }
                    else if (sum < index_sum)
                    {
                        index_sum = sum;
                        if(common_list[0] != "")
                        {
                            common_list = new String[list1.length];
                            k = 0;
                            common_list[k] = list2[j];
                            k++;
                        }
                    }
                }
            }
        }
        else
        {
            for(int i=0;i<list2.length;i++)
            {
                map.put(list2[i], i);
            } 
            
            for(int j=0;j<list1.length;j++)
            {
                if(map.containsKey(list1[j]))
                {
                    int sum = map.get(list1[j]) + j;
                    if(index_sum == null)
                    {
                        index_sum = sum;
                        common_list[k] = list1[j];
                        k++;
                    }
                    else if(index_sum == sum)
                    {
                        common_list[k] = list1[j];
                        k++;
                    }
                    else if (sum < index_sum)
                    {
                        index_sum = sum;
                        if(common_list[0] != "")
                        {
                            common_list = new String[list2.length];
                            k = 0;
                            common_list[k] = list1[j];
                            k++;
                        }
                    }
                }
            }
        }
        
        int null_count = 0; 
        
        for(int i=0;i<common_list.length;i++)
        {
            if(common_list[i] == null)
                null_count++;
        }
        
        String[] final_list =  new String[common_list.length - null_count];
        for(int i=0;i<final_list.length;i++)
        {
            final_list[i] = common_list[i];
        }
        
        return final_list;
    }
}