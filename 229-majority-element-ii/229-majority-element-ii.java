class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int count1 = 0, count2= 0 , element1 = -1 , element2 = -1, n = nums.length;
        
        for(int i : nums){
            
            if(i == element1) ++count1;
            
            else if(i == element2) ++count2;
            
            else if(count1 == 0){
                element1 = i;
                count1 = 1;
            }
            
            else if(count2 == 0){
                element2 = i;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
            
        }
        
        
        List<Integer> res = new ArrayList<>();
        
        int cnt1 = 0 , cnt2 = 0;
        
        for(int k : nums){
            
            if(k == element1)
                cnt1++;
            else if(k == element2)
                cnt2++;
            
        }
        
        if(cnt1 > n / 3)
            res.add(element1);
        if(cnt2 > n / 3)
            res.add(element2);
        
        return res;
        
        
    }
}