//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public void topoSort(int node,int[] visited,ArrayList<ArrayList<Integer>> edges, Stack<Integer> s){
        
        visited[node] = 1;
        
        for(int it : edges.get(node)){
            if(visited[it] == 0){
                topoSort(it,visited,edges,s);
            }
        }
        
        s.push(node);
        
    }
    
    public static void dfs(int node, int[] visited, List<List<Integer>> transpose)    {
        
        visited[node] = 1;
        
        for(int it: transpose.get(node)){
            if(visited[it] == 0)
                dfs(it,visited,transpose);
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> edges)
    {
        //code here
        Stack<Integer> s =  new Stack<>();
        int[] visited = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                topoSort(i,visited,edges,s);
            }
                
        }
        
        List<List<Integer>> transpose = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            transpose.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < n ; i++){
            visited[i] = 0;
            for(int it : edges.get(i)){
                transpose.get(it).add(i);
            }
        }
        
        
        int cnt = 0;
        while(!s.isEmpty()){
            int start = s.pop();
            if(visited[start] == 0){
                dfs(start,visited,transpose);
                cnt++;
            }
        }
        
        return cnt;
    }
}
