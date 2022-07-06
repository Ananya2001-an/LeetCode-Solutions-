class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        int start = image[sr][sc];
        image[sr][sc]=color;
        
        BFS(image,start,sr,sc,color);
        
        return image;
    }
    
    public static void BFS(int[][] image,int start,int i, int j, int color)
    {
        if(j-1 > -1)
        {
            if(image[i][j-1] == start)
            {
                image[i][j-1] = color;
                BFS(image,start,i,j-1,color);
            }
        }
        if(j+1 < image[i].length)
        {
            if(image[i][j+1] == start)
            {
                image[i][j+1] = color;
                BFS(image,start,i,j+1,color);
            }
        }
        if(i-1 > -1)
        {
            if(image[i-1][j] == start)
            {
                image[i-1][j] = color;
                BFS(image,start,i-1,j,color);
            }
        }
        if(i+1 < image.length)
        {
            if(image[i+1][j] == start)
            {
                image[i+1][j] = color;
                BFS(image,start,i+1,j,color);
            }
        }
    }
}