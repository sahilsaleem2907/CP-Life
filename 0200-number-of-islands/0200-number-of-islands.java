class Solution {
    
    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
      vis[ro][co] = 1; 
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(ro, co)); 
      int n = grid.length; 
      int m = grid[0].length; 
      
      // until the queue becomes empty
      while(!q.isEmpty()) {
          int row = q.peek().first; 
          int col = q.peek().second; 
          q.remove(); 
          
          for(int delrow = -1; delrow<=1;delrow++) {
                  int nrow = row + delrow; 
                  int ncol = col;
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                  && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1; 
                      q.add(new Pair(nrow, ncol)); 
                  }
          }
          
          for(int delcol = -1; delcol <= 1; delcol++) {
                  int nrow = row;
                  int ncol = col + delcol; 
              
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                  && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                      vis[nrow][ncol] = 1; 
                      q.add(new Pair(nrow, ncol)); 
                  }
          }
    
      }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    cnt++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        
        return cnt;
    }
}

class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        first = _first;
        second = _second;
    }
}