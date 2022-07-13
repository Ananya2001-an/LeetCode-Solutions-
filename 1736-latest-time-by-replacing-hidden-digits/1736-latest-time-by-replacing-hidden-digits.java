class Solution {
    public String maximumTime(String time) {
        if(time.charAt(0) == '?')
        {
            if(time.charAt(1) != '?' && Integer.parseInt("" + time.charAt(1)) > 3)
            {
                time = '1' + time.substring(1);
            }
            else
            {
                time = '2' + time.substring(1);
            }
        }
        
        if(time.charAt(1) == '?')
        {
            if(time.charAt(0) == '2')
                time = time.substring(0, 1) + '3' + time.substring(2);
            else
                time = time.substring(0, 1) + '9' + time.substring(2);
        }
        
        if(time.charAt(3) == '?')
        {
            time = time.substring(0, 3) + '5' + time.substring(4);
        }
        
        if(time.charAt(4) == '?')
        {
            time = time.substring(0, 4) + '9';
        }
        
        return time;
    }
}