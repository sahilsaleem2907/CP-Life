class Solution {
    public int uniquePaths(int m, int n) {
        
        int k = (m-1)+(n-1), r = m-1 ;
        double res = 1;
        
        for(int i = 1 ; i <= r ; i++)
            res = res * (k-r+i)/i;
            
        return (int)res;
        
    }
}