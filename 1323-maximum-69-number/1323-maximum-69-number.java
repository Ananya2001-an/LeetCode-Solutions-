class Solution {
    public int maximum69Number (int num) {
        
        String number = String.valueOf(num);
        
        for(int i=0; i<number.length();i++)
        {
            if(Integer.parseInt("" + number.charAt(i)) == 6)
            {
                number = number.substring(0, i) + '9' + number.substring(i+1);
                num = Integer.parseInt(number);
                return num;
            }
        }
        
        return num;
    }
}