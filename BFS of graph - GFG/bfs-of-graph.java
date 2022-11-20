//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public void bfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> path, Queue<Integer> q){
        
       
        q.offer(node);
        visited[node] = 1;
        
        while(!q.isEmpty()){
            
            int val = q.poll();
            path.add(val);
            
            for(int i : adj.get(val)){
                if(visited[i] == 0){
                    visited[i] = 1;
                    q.offer(i);
                }
            }
           
        }
        
        
        
    }
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V+1];
        ArrayList<Integer> path = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        bfs(0,visited,adj,path,q);
        
        return path;
        
    }
}