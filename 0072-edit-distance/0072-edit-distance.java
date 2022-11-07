class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n][m];
        
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        
        return helper(n-1,m-1,word1,word2,dp);
        
    }
    
    public int helper(int index1, int index2, String w1, String w2,int[][] dp){
        
        if(index1 < 0) return index2+1;
        
        if(index2 < 0) return index1+1;
        
        if(dp[index1][index2] != -1) return dp[index1][index2];
        
        
        if(w1.charAt(index1) == w2.charAt(index2)){
            //matches
            return dp[index1][index2] = 0 + helper(index1 - 1, index2 -1 ,w1,w2,dp);
        }
        else return dp[index1][index2] = 1 + Math.min(Math.min(helper(index1, index2 -1,w1,w2,dp),helper(index1-1, index2,w1,w2,dp)),helper(index1-1, index2 -1 ,w1,w2,dp));
        
        
    }
}