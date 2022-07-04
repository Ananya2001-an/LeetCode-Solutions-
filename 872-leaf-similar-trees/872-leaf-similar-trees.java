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
    
    static ArrayList<Integer> leaves1 = new ArrayList<Integer>();
    static ArrayList<Integer> leaves2 = new ArrayList<Integer>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        leafmethod1(root1);
        leafmethod2(root2);
        
        if (leaves1.size() != leaves2.size())
        {
                leaves1.clear();
                leaves2.clear();
                return false;
        } 
        
        for(int k=0;k<leaves1.size();k++)
        {
            if(leaves1.get(k) != leaves2.get(k))
            {
                leaves1.clear();
                leaves2.clear();
                return false;
            }   
        }
        
        leaves1.clear();
        leaves2.clear();
        return true;
    }
    
    public void leafmethod1(TreeNode root)
    {
        if(root!=null && root.left==null && root.right==null)
        {
            leaves1.add(root.val);
        }
        
        if(root!=null)
        {
            if(root.left != null)
            {
                leafmethod1(root.left);
            }
            if(root.right != null)
            {
                leafmethod1(root.right);
            }
        }
        
    }
    
    public void leafmethod2(TreeNode root)
    {
        if(root!=null && root.left == null && root.right == null)
        {
            leaves2.add(root.val);
        }
        
        if(root!=null)
        {
            if(root.left != null)
            {
                leafmethod2(root.left);
            }
            if(root.right != null)
            {
                leafmethod2(root.right);
            }
        }
        
    }
}