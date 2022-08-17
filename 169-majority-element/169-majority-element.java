class Solution {
    public int majorityElement(int[] nums) {
        
        
        Arrays.sort(nums);
        
        int val = (int) Math.floor(nums.length/2);
        
        int count = 1;
        int ini = nums[0];
        
        for(int i = 1 ; i < nums.length; i++){
            
            if(nums[i] != ini)
                if(count > val)
                    return ini;
                else
                    count = 0;
            
            ini = nums[i];
            ++count;      
            
        }
       
        if(count != 0)
            return ini;
        
        return nums[0];
    }
}