class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n > 0)
        {
            if(flowerbed.length == 1)
            {
                if(flowerbed[0] == 0)
                {
                    n--;
                    if(n == 0)
                        return true;
                    else
                        return false;
                }
                else
                    return false;
            }
            
            if(flowerbed.length == 2)
            {
                if(flowerbed[0] == 0 && flowerbed[1] == 0)
                {
                    n--;
                    if(n == 0)
                        return true;
                    else
                        return false;
                }
                else
                    return false;
            }
            
            int i=0;
            
            while(i + 2 != flowerbed.length)
            {
                if(flowerbed[i]==0 && flowerbed[i+1]==0 && flowerbed[i+2]==0)
                {
                    if (i + 3 != flowerbed.length && flowerbed[i+3] == 0 || i + 3 == flowerbed.length)
                    {
                        flowerbed[i] = 1;
                        flowerbed[i+2] = 1;
                        n = n-2;
                    }
                    else if(i + 3 != flowerbed.length && flowerbed[i+3] == 1)
                    {
                        flowerbed[i+1] = 1;
                        n--;
                    }
                }
                
                else if(flowerbed[i]==0 && flowerbed[i+1]==0 && flowerbed[i+2]==1)
                {
                    if(i!=0 && flowerbed[i-1] == 0 || i==0)
                    {
                        flowerbed[i] = 1;
                        n--;
                    }                
                }
                
                else if (flowerbed[i]==1 && flowerbed[i+1]==0 && flowerbed[i+2]==0)
                {
                    if(i + 3 != flowerbed.length && flowerbed[i+3] == 0 || i + 3 == flowerbed.length)
                    {
                        flowerbed[i+2] = 1;
                        n--;
                    }
                }
                
                i++;
            }
            
            
            if(n == 0 || n < 0)
                return true;
            else
                return false;
        }
        
        return true;    
    }
}