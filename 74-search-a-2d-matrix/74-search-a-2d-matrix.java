class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int lastIndexColumn = matrix[0].length-1;
        
        for(int i = 0 ; i < matrix.length ; i++){
            int lastInVal = matrix[i][lastIndexColumn];
            
            
            if(target <= lastInVal)
            {
                for(int j = lastIndexColumn ; j >= 0 ; j--)
                    if(target == matrix[i][j])
                        return true;
            }
        }
        
        return false;
        
    }
}