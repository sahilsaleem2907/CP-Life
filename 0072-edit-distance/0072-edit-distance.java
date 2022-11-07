class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i <= n ;i++) dp[i][0] = i;
        for(int j = 0; j <= m ;j++) dp[0][j] = j;
        
        for(int i = 1 ; i <= n ;i++){
            for(int j = 1; j <= m; j++){
        
            if(word1.charAt(i-1) == word2.charAt(j-1)){
            //matches
                dp[i][j] = 0 + dp[i-1][j-1];
            }else{
            
                dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
            
            }
                
            }
        }
        
        return dp[n][m];
        
    }
    
    
//     public int minDistance(String word1, String word2) {
        
//         int n = word1.length();
//         int m = word2.length();
        
//         int[][] dp = new int[n][m];
        
//         Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        
//         return helper(n-1,m-1,word1,word2,dp);
        
//     }
    
//     public int helper(int index1, int index2, String w1, String w2,int[][] dp){
        
//         if(index1 < 0) return index2+1;
        
//         if(index2 < 0) return index1+1;
        
//         if(dp[index1][index2] != -1) return dp[index1][index2];
        
        
//         if(w1.charAt(index1) == w2.charAt(index2)){
//             //matches
//             return dp[index1][index2] = 0 + helper(index1 - 1, index2 -1 ,w1,w2,dp);
//         }
//         else return dp[index1][index2] = 1 + Math.min(Math.min(helper(index1, index2 -1,w1,w2,dp),helper(index1-1, index2,w1,w2,dp)),helper(index1-1, index2 -1 ,w1,w2,dp));
        
        
//     }
    
}