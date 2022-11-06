//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n][W+1];
         
         Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
         
         return helper(n-1,W,dp,wt,val);
         
         
    } 
    
    static int helper(int i, int weight, int[][]dp, int[] wt, int[] val){
        
        if(i == 0){
            if(wt[0] <= weight)
                return val[0];
            else
                return 0;
        }
        
        if(dp[i][weight] != -1) return dp[i][weight];
        
        int notTake = 0 + helper(i-1,weight,dp,wt,val);
        
        int take = Integer.MIN_VALUE;
        
        if(wt[i] <= weight){
            take = val[i] + helper(i-1,weight-wt[i],dp,wt,val);
        }
        
        
        return dp[i][weight] = Math.max(take,notTake); 
        
        
    }
}


