class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        
    int n=s1.length();
    int m=s2.length();
    
    // Base Case is covered as we have initialized the prev and cur to 0.
    int prev[]=new int[m+1];
    int cur[]=new int[m+1];
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1))
                cur[j] = 1 + prev[j-1];
            else
                cur[j] = 0 + Math.max(prev[j],cur[j-1]);
        }
        prev=(int[])(cur.clone());
    }
    
    return prev[m];
        
    }
}