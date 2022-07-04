/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    static List<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> preorder(Node root) {
        
        if(root == null)
            return list;
        
        traverse(root);
        
        List<Integer> ans = new ArrayList<Integer>(list);
        list.clear();
        return ans;
        
    }
    
    public static void traverse(Node root)
    {
        if(root == null)
            return;
        list.add(root.val);
        
        if(root.children.size()!=0)
        {
            int i=0;
            while(i != root.children.size())
            {
                traverse(root.children.get(i));
                i++;
            }
        }
        
        
    }
}