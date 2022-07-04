class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int firstOne = 0;
        int secondOne = 0;
        for(int i=0; i < nums.length; i++){
            if(firstOne > 0 && nums[i]==1){
               secondOne = i+1;
               if(secondOne - firstOne != k+1 && secondOne - firstOne < k+1)           {
                    return  false;
               }
                else{
                    firstOne = i+1;
                    secondOne = 0;
               }
            }
            else
            {
                if(nums[i]==1){
                    firstOne = i+1;   
                }
            }
            
        }
        
        return true;
    }
}