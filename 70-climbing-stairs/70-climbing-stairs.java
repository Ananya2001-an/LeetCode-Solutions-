class Solution {
    
    static Integer[] arr = new Integer[46];
  
    public int climbStairs(int n) {
        int value = climb(n);
        
        Arrays.fill(arr, null);
        
        return value;
    }
    
    public static int climb(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(arr[n] != null)
            return arr[n];
        
        arr[n] = climb(n-1) + climb(n-2);
        return arr[n];
    }
}