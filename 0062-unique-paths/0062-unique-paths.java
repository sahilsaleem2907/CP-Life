class Solution {
    public int uniquePaths(int m, int n) {
        
        int k = (m-1)+(n-1), r = m-1 ;
        double res = 1;
        
        for(int i = 1 ; i <= r ; i++)
            res = res * (k-r+i)/i;
            
        return (int)res;
        
    }
    
//     public int uniquePaths(int m, int n) {
//         int[][] paths = new int[m][n]; //path[i][j] indicates number of paths possible to reach destination from (i,j) cell
//         int rows = m, cols = n;
//         for(int row = rows-1; row >=0; row--) {
//             for(int col = cols-1; col >= 0; col--) {
//                 if(row == rows-1 || col == cols-1) paths[row][col] = 1; 
//                 else
//                     paths[row][col] = paths[row][col+1] + paths[row+1][col];    
                
//             }
//         }
//         return paths[0][0];
//     }
}