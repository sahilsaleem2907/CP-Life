class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0 || x == 1.0 || (x == -1 && n < 0))
            return 1.0;
        
        double res= 1.0;
        int upperLimit = Math.abs(n) % 1000000007;
        
        
        for(int i = 0 ; i < upperLimit ; i++){
            
            if(n < 0)
              res /= x;
            else
              res *= x;
        
            
        }
        
        if(res == 1)
            return 0.0;
        
        return res;
        
    }
}