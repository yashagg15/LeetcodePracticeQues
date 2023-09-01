//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public int deletionCount(char[] arr, int front, int end, int dp[][]){
        
        if(front==end || front>end){
            return 0;
        }
        
        if(dp[front][end]!=-1){
            return dp[front][end];
        }
        
        if(arr[front]==arr[end]){
            return deletionCount(arr,front+1,end-1,dp);
        }
        int frontConsider=1+deletionCount(arr,front,end-1,dp);
        int endConsider=1+deletionCount(arr,front+1,end,dp);
        return dp[front][end]=Math.min(frontConsider,endConsider);
        
        
    }
    int minDeletions(String str, int n)
    {
        // code here
        int len=str.length();
        int dp[][]=new int[len][len];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int count=deletionCount(str.toCharArray(),0,len-1,dp);
        return count;
    }
} 