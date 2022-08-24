class NumArray {
    
    int fen[],arr[];
    int n;

    public NumArray(int[] nums) {
        
        arr = nums;
        n = nums.length;
        fen = new int[n+1];
        helper();
        
    }
    
    public void helper(){
        
        fen[1] = arr[0];
        
        for(int i = 1 ; i < n ; i++){
            
            fen[i+1] = fen[i] + arr[i];
            
        }
        
        for(int i = n ; i > 0 ; i--){
            
            int parent = i - (i & -i);
            fen[i] -= fen[parent];
            
        }
        
        
    }
    
    public int sum(int i){
        
        int res = 0;
        while(i > 0){
            res += fen[i];
            i = i - (i & -i);
        }
        
        return res;
        
    }
    
    public void upHelper(int i , int val){
        
        i++;
        while(i <= n){
            fen[i] += val;
             i = i + (i & -i);
        }
        
    }
    
    public void update(int index, int val) {
        
        int target = val - arr[index];
        
        arr[index] = val;
        
        upHelper(index,target);
        
        
    }
    
    public int sumRange(int left, int right) {
        
        return sum(right+1)-sum(left);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */