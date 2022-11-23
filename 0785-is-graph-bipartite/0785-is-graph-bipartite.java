class Solution {
    
    public boolean dfs(int start, int[] color, int[][] graph){
        
        for(int i : graph[start]){
            if(color[i] == -1){
                color[i] = 1-color[start];
                if(!dfs(i,color,graph))
                    return false;
            }else if(color[i] == color[start])
                return false;
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        
        int color[] = new int[V];
        
        for(int i = 0;i<V;i++) color[i] = -1; 
        
        for(int i = 0 ; i < V; i++){
            if(color[i] == -1)
                if(dfs(i,color,graph) == false)
                    return false;
        }
        
        return true;
    }
}

/* BFS */
// class Solution {
    
//     public boolean bfs(int start, int[] color, int[][] graph){
        
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(start);
//         color[start] = 0;
        
//         while(!q.isEmpty()){
            
//             int node = q.peek();
//             q.poll();
            
//             for(int i : graph[node]){
//                 if(color[i] == -1){
//                     color[i] = 1 - color[node];
//                     q.offer(i);
//                 }else if(color[i] == color[node]){
//                     return false;
//                 }
//             }
            
//         }
        
//         return true;
//     }
    
//     public boolean isBipartite(int[][] graph) {
        
//         int V = graph.length;
        
//         int color[] = new int[V];
        
//         for(int i = 0;i<V;i++) color[i] = -1; 
        
//         for(int i = 0 ; i < V; i++){
//             if(color[i] == -1)
//                 if(bfs(i,color,graph) == false)
//                     return false;
//         }
        
//         return true;
        
//     }
// }