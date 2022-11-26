//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
        int i, j, max = 0;
        int dp[] = new int[n];
 
        /* Initialize dp values
           for all indexes */
        for (i = 0; i < n; i++)
            dp[i] = arr[i];
 
        /* Compute maximum sum values
           in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] &&
                    dp[i] < dp[j] + arr[i])
                    dp[i] = dp[j] + arr[i];
 
        /* Pick maximum of all
           dp values */
        for (i = 0; i < n; i++)
            if (max < dp[i])
                max = dp[i];
 
        return max;
	}  
	
    
//     public int maxSumIS(int arr[], int n)  
// 	{  
// 	    //code here.
        
//         int[][]dp = new int[n][n+1];
//         Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        
//         return helper(0,-1,n,arr,dp);
// 	}  
	
    
//     public int helper(int index, int prev,int n, int[] nums,int[][] dp){
        
//          if(index == n) return 0 ;
         
//          if(dp[index][prev+1] != -1) return dp[index][prev+1];
        
         
//          int length = 0 + helper(index+1,prev,n,nums,dp); //not taking the item
        
//          if(prev == -1 || nums[index] > nums[prev]){
            
//             length = Math.max(length,nums[index]+helper(index+1,index,n,nums,dp));
            
//          }
        
        
//          return dp[index][prev+1] = length;
        
//     }
}