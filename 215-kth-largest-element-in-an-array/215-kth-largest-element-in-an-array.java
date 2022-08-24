class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums);
        reverse(nums);
    
        
        return nums[k-1];
        
    }
    
    public void reverse(int[] arr){
        
        int n = arr.length;
        int temp = 0;
        
        for(int i = 0 ; i < n/2 ; i++){
            
            temp = arr[i];
            arr[i]= arr[n-1-i];
            arr[n-1-i] = temp;          
            
        }
        
        
    }
}