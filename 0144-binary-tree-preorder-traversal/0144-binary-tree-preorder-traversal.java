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
    
     /* Morris Pre Order*/
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
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
                    res.add(curr.val);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
                
            }
            
        }
        
        return res;
        
    }
    
//     List<Integer> res = new ArrayList<>();
    
//     public List<Integer> preorderTraversal(TreeNode root) {
        
//         helper(root);
        
//         return res;
        
//     }
    
//     public void helper(TreeNode root){
        
//         if(root == null) return;
        
//         res.add(root.val);
//         helper(root.left);
//         helper(root.right);
        
//     }
}