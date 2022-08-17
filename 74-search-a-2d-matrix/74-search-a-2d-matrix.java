class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i = 0, j = matrix[0].length-1, n = matrix.length,m =matrix[0].length;
        
        while(i < n && j >= 0){
            
            if(matrix[i][j] == target)
                return true;
            
            if(matrix[i][j] > target)
                j--;
            else
                i++;
                
            
        }
    
       return false;
        
    }
}