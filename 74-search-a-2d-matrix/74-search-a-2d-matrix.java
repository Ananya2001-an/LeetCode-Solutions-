class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int col = matrix[0].length - 1;
        boolean result = BinSearch(matrix, target, row, col);
        return result;
    }
    
    static boolean BinSearch(int[][] matrix, int goal, int row, int col)
    {
        if(row < matrix.length && col > -1)
        {
            if(matrix[row][col] == goal)
                return true;
            else if(matrix[row][col] < goal)
                return BinSearch(matrix, goal, row+1, col);
            else
                return BinSearch(matrix, goal, row, col-1);
                
        }
        return false;
    }
    
}