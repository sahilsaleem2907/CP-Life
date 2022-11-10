class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true; //base case
        
        for(int i = 1 ; i <= n ; i++){
            
            for(int j = 0 ; j < i; j++){
                
                if(dp[j] && wordDict.contains(s.substring(j,i))) dp[i] = true;
                
            }
            
        }
        
        return dp[n];
    }
    
/* Recursion + Memoization */
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         Set<String> set = new HashSet<>();
        
//         for(String s1 : wordDict){
            
//             set.add(s1);
            
//         }
        
//         return helper(s,set, new HashMap<String,Boolean>());
        
//     }
    
//     public boolean helper(String s, Set<String> set, Map<String,Boolean> map){
        
//         if(s.length() == 0) return true;
        
//         if(map.containsKey(s)) return map.get(s);
        
//         for(int i = 1 ; i <= s.length() ; i++){
            
//             if(set.contains(s.substring(0,i)) && helper(s.substring(i,s.length()),set,map)){
                
//                 map.put(s.substring(i,s.length()),true);
//                 return true;
//             }
            
//         }
        
//         map.put(s,false);
//         return false;
        
//     }
}