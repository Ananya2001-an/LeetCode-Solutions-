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
    public int getMinimumDifference(TreeNode root) {
        
        int mindiff = 0;
        
        if(root.left != null)
            mindiff = Math.abs(root.val - root.left.val);
        else
            mindiff = Math.abs(root.val - root.right.val);
        
        ArrayList<TreeNode> internal = new ArrayList<TreeNode>();
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        
        internal.add(root);
        if(root.left != null)
            children.add(root.left);
        
        if(root.right != null)
            children.add(root.right);
        
        while(children.isEmpty() != true)
        {
            for(int i=0;i<internal.size();i++)
            {
                for(int j=0;j<children.size();j++)
                {
                    if(Math.abs(internal.get(i).val - children.get(j).val) < mindiff)
                        mindiff = Math.abs(internal.get(i).val - children.get(j).val);
                }
            }
            
            for(int j=0;j<children.size();j++)
            {
                for(int k=j+1;k<children.size();k++)
                {
                    if(Math.abs(children.get(j).val - children.get(k).val) < mindiff)
                        mindiff = Math.abs(children.get(j).val - children.get(k).val);
                }
            }
            
            internal.addAll(children);
            temp = (ArrayList)children.clone();
            children.clear();
            for(int k=0;k<temp.size();k++)
            {
                if(temp.get(k) != null && temp.get(k).left != null)
                    children.add(temp.get(k).left);
                if(temp.get(k) != null && temp.get(k).right != null)
                    children.add(temp.get(k).right);
            }
        }
       
        return mindiff;
    }
}