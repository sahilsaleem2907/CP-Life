//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
                
        int[][] dp = new int[n][n];
        
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        
        
        return helper(0,n-1,str,dp);
    }
    
    static int helper(int i, int j, String str,int[][] dp){
        
        if(i == j || isPalindrome(str,i,j)) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k <= j-1 ; k++){
            
        
             min = Math.min(min,1 + helper(i,k,str,dp) + helper(k+1,j,str,dp));
           
        }
        
        return dp[i][j] = min;
        
    }
    
    static boolean isPalindrome(String string, int i, int j)
    {
        while(i < j)
        {
        if(string.charAt(i) != string.charAt(j))
            return false; 
        i++;
        j--;
        }
        return true;
    }
    
}