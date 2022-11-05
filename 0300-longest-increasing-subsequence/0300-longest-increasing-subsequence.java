class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        if(n <= 1)
            return n;
        
        int[] dp = new int[n];
        int max = -1;
        Arrays.fill(dp,1);
        
        for(int i = 1; i < n; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            
            max = Math.max(max,dp[i]);
        }
        
        return max;
        
    }
    
//      public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
        
//         int[][]dp = new int[n][n+1];
//         Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        
//         return helper(0,-1,n,nums,dp);
//     }
    
    
//     public int helper(int index, int prev,int n, int[] nums,int[][] dp){
        
//          if(index == n) return 0 ;
         
//          if(dp[index][prev+1] != -1) return dp[index][prev+1];
        
         
//          int length = 0 + helper(index+1,prev,n,nums,dp); //not taking the item
        
//          if(prev == -1 || nums[index] > nums[prev]){
            
//             length = Math.max(length,1+helper(index+1,index,n,nums,dp));
            
//          }
        
        
//          return dp[index][prev+1] = length;
        
//     }
}