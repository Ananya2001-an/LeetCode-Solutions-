class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[index.length];
            for(int j=0;j<index.length;j++)
            {
                if(target[index[j]] == -1){
                     target[index[j]] = nums[j];   
                }
                else{
                    int i = j;
                    while(i > index[j]){
                        target[i] = target[i-1]; 
                        i--;
                    }
                    
                    target[index[j]] = nums[j];
                    
                }
                
            }
        
        return target;
    }
}