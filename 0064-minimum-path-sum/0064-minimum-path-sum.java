class Solution {
    public int minPathSum(int[][] grid) {
        
         int m = grid.length;
         int n = grid[0].length;
        
         if(m == 1 && n == 1) return grid[m-1][n-1];
        
         int[][] dp = new int[m][n];
        
         Arrays.stream(dp).forEach(a  -> Arrays.fill(a,-1));
         
         return helper(0,0,grid,m,n,dp);
    }
    
    public int helper(int i, int j, int[][] grid,int r, int c,int[][] dp){
    
        if(i == r-1 && j == c-1){
            return  dp[i][j] = grid[i][j];
        }
         
        if(i == r){
            return  dp[i-1][j] = Integer.MAX_VALUE; 
        }
        
        if(j == c)
        {
            return  dp[i][j-1] = Integer.MAX_VALUE; 
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        
        //down  and right
        int sum = grid[i][j] + Math.min(helper(i+1,j,grid,r,c,dp),helper(i,j+1,grid,r,c,dp));
    
        return  dp[i][j] = sum;
        
        
        
    }
}