/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
           return true;
        else if(p == null && q != null || p != null && q == null)
            return false;
        
        ArrayList<TreeNode> p_tree = new ArrayList<TreeNode>();
        ArrayList<TreeNode> q_tree = new ArrayList<TreeNode>();
        ArrayList<TreeNode> temp1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> temp2 = new ArrayList<TreeNode>();
        
        p_tree.add(p);
        q_tree.add(q);
        
        
        
        while(p_tree.isEmpty() != true && q_tree.isEmpty() != true)
        {
            if(p_tree.size() != q_tree.size())
                return false;
                
            for(int i=0;i<p_tree.size();i++)
            {
                if(p_tree.get(i) != null && q_tree.get(i) == null)
                    return false;
                
                if(p_tree.get(i) == null && q_tree.get(i) != null)
                    return false;
                    
                if(p_tree.get(i) != null && q_tree.get(i) != null && p_tree.get(i).val != q_tree.get(i).val)
                    return false;
            }
            
            temp1 = (ArrayList)p_tree.clone();
            temp2 = (ArrayList)q_tree.clone();
            
            p_tree.clear();
            q_tree.clear();
            
            for(int j=0;j<temp1.size();j++)
            {
                if(temp1.get(j) != null)
                {
                   p_tree.add(temp1.get(j).left);
                   p_tree.add(temp1.get(j).right);
                    
                }
                
                if(temp2.get(j) != null)
                {
                   q_tree.add(temp2.get(j).left);
                   q_tree.add(temp2.get(j).right);
                    
                }
                
            }
            
            
        }
       
        if(p_tree.isEmpty() == true && q_tree.isEmpty() == true)
            return true;
        else
            return false;
        
    }
}