class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        String a = "++X";
        String b = "X++";
        for(int i=0; i < operations.length;i++){
        if(a.equals(operations[i]) ||                                         b.equals(operations[i]) )         {
            X = X + 1;    
        }
        else{
            
            X = X - 1;
        }
        
        }
        return X;
    }
}