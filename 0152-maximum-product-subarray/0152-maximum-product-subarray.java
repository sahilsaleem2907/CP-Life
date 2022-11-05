class Solution {
    public int maxProduct(int[] nums) {
        
        int max_prod = nums[0], min_prod = nums[0], max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
            int temp = Math.max(nums[i],Math.max(max_prod * nums[i], min_prod * nums[i]));
            min_prod = Math.min(nums[i],Math.min(max_prod * nums[i],min_prod * nums[i]));
            max_prod = temp;
            
            max = Math.max(max_prod,max);
            
            
        }
        
        return max;
        
    }
}