class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int breadth = (height.length - 1);
        int max_area = breadth*(Math.min(height[i], height[j]));
        
        if(height[i] <= height[j])
            i++;
        else
            j--;
        
        breadth--;
        
        while(i!=j)
        {
            int current_area = breadth*(Math.min(height[i], height[j]));
            if(current_area > max_area)
                max_area = current_area;
            
            if(height[i] <= height[j])
                i++;
            else
                j--;
            breadth--;
        }
        
        return max_area;
    }
}