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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        Map<Integer, Map<Integer,List<Integer>>> map = new TreeMap<>();
        
        if(root == null) return ans;
        
        q.add(new Pair(root,0,0));
        
        while(!q.isEmpty()){
            
            Pair temp = q.remove();
            int x = temp.row;
            int y = temp.col;
            
             Map<Integer,List<Integer>> colMap = map.getOrDefault(x,new TreeMap<Integer,List<Integer>>());
            
             List<Integer> list = colMap.getOrDefault(y,new ArrayList<Integer>());
             list.add(temp.node.val);
            
             Collections.sort(list);
             colMap.put(y,list);
            
             map.put(x,colMap);
        
             
            if(temp.node.left != null){
                q.add(new Pair(temp.node.left,x+1,y-1));
            }
            
            if(temp.node.right != null){
                q.add(new Pair(temp.node.right,x+1,y+1));
            }
            
        }
        
        Map<Integer,List<Integer>> resMap = new TreeMap<>();
        
        for (Map.Entry<Integer, Map<Integer,List<Integer>>> entry : map.entrySet()){
            
            Map<Integer,List<Integer>> finalMap = entry.getValue();
            
            for (Map.Entry<Integer,List<Integer>> entry2 : finalMap.entrySet()){
                
             List<Integer> tempList = finalMap.getOrDefault(entry2.getKey(),new ArrayList<>());
             List<Integer> temp2 = resMap.getOrDefault(entry2.getKey(), new ArrayList<>());
             temp2.addAll(tempList);
             resMap.put(entry2.getKey(),temp2);
                
            }
        }
        
        for(Map.Entry<Integer,List<Integer>> entry : resMap.entrySet()){
            
            ans.add(entry.getValue());
            
        }
        
        
        return ans;
        
    }
}

class Pair
{
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode a, int b, int c)
    {
        node=a;
        row=b;
        col=c;
        
    }
    
}