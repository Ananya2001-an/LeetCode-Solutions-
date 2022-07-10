class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        
        Map<Integer, Integer> map = new HashMap();
        
        for(int i=0; i<arr.length; i++)
        {
            if (arr[i]%2 != 0 && arr[i]>0||arr[i]%2 == 0 && arr[i]>=0 && map.containsKey(arr[i]/2) == false)
            {
                boolean res = BinSearch(arr, i+1, arr.length-1, 2*arr[i]);
                if(res == true)
                    return true;
                else
                {
                    map.put(arr[i], 0);
                    continue;
                }
            }
            else if(arr[i]%2 == 0 && arr[i]<0 && map.containsKey(2*arr[i]) == false)
            {
                boolean res = BinSearch(arr, i+1, arr.length-1, arr[i]/2);
                if(res == true)
                    return true;
                else
                {
                    map.put(arr[i], 0);
                    continue;
                }
            }
            else if(arr[i]%2 != 0)
            {
                if(map.containsKey(2*arr[i]))
                    return true;
                else
                {
                    map.put(arr[i], 0);
                    continue;
                }
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    public boolean BinSearch(int[] arr, int low, int high, int search)
    {
        if(low<=high)
        {
            int middle = (low+high)/2;
            
            if(arr[middle] == search)
                return true;
            else if(arr[middle] > search)
                return BinSearch(arr, low, middle-1, search);
            else
                return BinSearch(arr, middle+1, high, search);
        }
        
        return false;
    }
}