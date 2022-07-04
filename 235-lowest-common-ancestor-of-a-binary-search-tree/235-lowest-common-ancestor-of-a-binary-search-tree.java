/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p_parent =  new ArrayList<TreeNode>();
        ArrayList<TreeNode> q_parent =  new ArrayList<TreeNode>();
        
        TreeNode current_p = root;
        TreeNode current_q = root;
        
        boolean p_found = false;
        boolean q_found = false;
        
        while(p_found == false && q_found == false)
        {
            if(current_p!=null && current_p.val == p.val)
                p_found = true;
            else if(current_p!=null && current_p.val > p.val)
            {
                p_parent.add(current_p);
                current_p = current_p.left;
            }
            else if (current_p!=null && current_p.val < p.val)
            {
                p_parent.add(current_p);
                current_p = current_p.right;
            }
            
            if(current_q!=null && current_q.val == q.val)
                q_found = true;
            else if(current_q!=null && current_q.val > q.val)
            {
                q_parent.add(current_q);
                current_q = current_q.left;
            }
            else if (current_q!=null && current_q.val < q.val)
            {
                q_parent.add(current_q);
                current_q = current_q.right;
            }
        }
        
        if(p_parent.indexOf(q) != -1)
            return q;
        else if(q_parent.indexOf(p) != -1)
            return p;
        else
        {
            p_parent.retainAll(q_parent);
            return p_parent.get(p_parent.size()-1);
        }
    }
}