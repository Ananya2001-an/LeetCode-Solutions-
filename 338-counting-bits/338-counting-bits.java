class Solution {
    
    static int[] arr = new int[0];
    static int max = 0;
    static int key = 1;
    
    public int[] countBits(int n) {
        arr = new int[n+1];
        arr[0] = 0;
        if(n > 0)
            arr[1] = 1; 
        
        count(2);
        
        key = 1;
        max = 0;
        
        return arr;
    }
    
    public static void count(int i)
    {
        if(i >= arr.length)
            return;
        
        if((i & (i - 1)) == 0) //power of 2 or not
        {
            arr[i] = 1;
            if(i > max)
                max = i;
            key++;
        }
        else
        {
            int diff = i - max;
        
            arr[i] = 1 + arr[diff];
        }
        count(i+1);
        
    }
        
}