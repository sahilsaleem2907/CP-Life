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
    
    /* Morris Inorder */
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null){
            
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                
                TreeNode prev = curr.left;
                
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;                                        
                }
                
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
                
            }
            
        }
        
        return res;
        
    }
    
//     List<Integer> res = new ArrayList<>();
    
//     public List<Integer> inorderTraversal(TreeNode root) {
        
//        helper(root);
        
//        return res;
        
//     }
    
//     public void helper(TreeNode root){
        
//         if(root == null)
//             return;
        
//         helper(root.left);
//         res.add(root.val);
//         helper(root.right);
        
//     }
}