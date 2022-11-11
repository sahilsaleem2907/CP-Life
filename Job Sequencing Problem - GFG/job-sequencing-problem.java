//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int res[] = new int[2];
        Arrays.sort(arr,((a,b) -> b.profit - a.profit));
        
        int maxDeadline = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            
            if(arr[i].deadline > maxDeadline)
                maxDeadline = arr[i].deadline;
            
        }
        
        int dp[] = new int[maxDeadline + 1];
        Arrays.fill(dp,-1);
        
        int count = 0 , profit = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            for(int j = arr[i].deadline; j > 0 ; j--){
                
                if(dp[j] == -1){
                    
                    //free slot
                    dp[j] = arr[i].id;
                    profit += arr[i].profit;
                    count++;
                    break; //you 
                    
                }
                
            }
            
        }
        
        res[0] = count;
        res[1] = profit;
        
        return res;
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/