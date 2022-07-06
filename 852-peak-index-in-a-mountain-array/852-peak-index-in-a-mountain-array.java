class Solution {
    static Integer peak_index = null;
    static Integer peak_value = null;
    
    public int peakIndexInMountainArray(int[] arr) {
        BinSearch(arr, 0, arr.length-1);
        Integer ans = peak_index;
        peak_index = null;
        peak_value = null;
        return ans;
    }
    
    public static void BinSearch(int[] arr, int low, int high)
    {
        if (low<=high)
        {
            int middle = (low + high)/2;
        
            if(middle-1 != -1 && arr[middle-1] < arr[middle])
            {
                if (peak_value == null && peak_index == null)
                {
                    peak_value = arr[middle];
                    peak_index = middle;
                }
                
                else if(peak_value < arr[middle])
                {
                  peak_value = arr[middle];
                  peak_index = middle;  
                }
                
                BinSearch(arr, middle+1, high);
            }
            else if (middle-1 != -1 && arr[middle-1] > arr[middle])
            {
                if (peak_value == null && peak_index == null)
                {
                    peak_value = arr[middle-1];
                    peak_index = middle-1;
                }
                
                else if(peak_value < arr[middle-1])
                {
                  peak_value = arr[middle-1];
                  peak_index = middle-1;  
                } 
                
                BinSearch(arr, low, middle-1);
            }
        }
    }
}