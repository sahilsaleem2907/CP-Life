//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/* Kruskal Algorithm */
class Node{
    int u;
    int v;
    int weight;
    
    Node(int _u,int _v,int _weight){
        u = _u;
        v = _v;
        weight = _weight;
    }
    
    int getU(){return u;}
    int getV(){return v;}
    int getWeight(){return weight;}
}

class SortComparator implements Comparator<Node>{
    @Override
    public int compare(Node node1, Node node2){
        
        if(node1.getWeight() < node2.getWeight())
            return -1;
        else if(node1.getWeight() > node2.getWeight())
            return 1;
            
        return 0;
    }
}

class Solution
{
    
    static int findPar(int u, int[] parent){
        if(u == parent[u]) return u;
        
        return parent[u] = findPar(parent[u],parent);
    }
    
    static void union(int u, int v, int[] parent, int[] rank){
        
        u = findPar(u,parent);
        v = findPar(v,parent);
        
        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if (rank[u] > rank[v]){
            parent[v] = u;
        }else{
            parent[v] = u;
            rank[u]++;
        }
        
    }
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        
        ArrayList<Node> adjUpdated = new ArrayList<Node>();
        
        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < adj.get(i).size() ;  j++){
                adjUpdated.add(new Node(i,adj.get(i).get(j).get(0),adj.get(i).get(j).get(1)));
            }
        }
        
        Collections.sort(adjUpdated,new SortComparator());
        int[] parent = new int[V];
        int[] rank = new int[V];
        
        for(int i = 0 ; i  < V ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        int cost = 0;
        
        ArrayList<Node> mst = new ArrayList<Node>();
        
        for(Node it : adjUpdated){
            int u = it.getU();
            int v = it.getV();
            int wt = it.getWeight();
            
            if(findPar(u,parent) != findPar(v,parent)){
                cost += wt;
                mst.add(it);
                union(u,v,parent,rank);
            }
        }
        
        
        return cost;
        
        
    }
}

/* Prims Algorithm */

// class Pair{
//     int node;
//     int distance;
    
//     Pair(int _node, int _distance){
//         node = _node;
//         distance =_distance;
//     }
    
// }
// class Solution
// {
//     //Function to find sum of weights of edges of the Minimum Spanning Tree.
//     static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
//     {
//         // Add your code here
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
//         int[] visited = new int[V];
        
//         pq.offer(new Pair(0,0));
        
//         int sum = 0;
        
//         while(!pq.isEmpty())
//         {
//             int node = pq.peek().node;
//             int wt = pq.peek().distance;
//             pq.poll();
            
//             if(visited[node] == 1) continue;
            
//             visited[node] = 1;
//             sum += wt;
            
//             for(int i = 0; i< adj.get(node).size(); i++){
//                 int adjNode = adj.get(node).get(i).get(0);
//                 int edgeW = adj.get(node).get(i).get(1);
                
//                 if(visited[adjNode] == 0) pq.offer(new Pair(adjNode,edgeW));
//             }
            
//         }
        
//         return sum;
        
//     }
// }