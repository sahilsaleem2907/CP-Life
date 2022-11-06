class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        
        int dp[][] = new int[n+1][m+1];
            
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        
        return helper(n,m,dp,text1,text2);
        
    }
    
    public int helper(int i, int j, int[][] dp, String text1, String text2){
        
        if(i == 0 || j == 0 ) 
            return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return dp[i][j] = 1 + helper(i-1,j-1,dp,text1,text2);
        }
        
        return dp[i][j]  = 0 + Math.max(helper(i,j-1,dp,text1,text2),helper(i-1,j,dp,text1,text2));
        
    }
    
    /* Space is 0(N * M ) + O(N+M); -- > NOT OPTIMISED */
}