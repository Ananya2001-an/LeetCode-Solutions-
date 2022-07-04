class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        
        int[] old_score = score.clone();
        
        Arrays.sort(score);
        
        Map<Integer, String> map = new HashMap();
        
        for(int i=score.length-1;i>=0;i--)
        {
            if(i == score.length - 1)
            {
                map.put(score[score.length-1], "Gold Medal");
            }
            else if (i == score.length - 2)
            {
                map.put(score[score.length-2], "Silver Medal");
            }
            else if(i == score.length - 3)
            {
                map.put(score[score.length-3], "Bronze Medal");
            }
            else
            {
                map.put(score[i], Integer.toString(score.length - i));   
            }
        }
        
        for(int i=0;i<old_score.length;i++)
        {
            ranks[i] = map.get(old_score[i]); 
        }
        
        return ranks;
    }
}