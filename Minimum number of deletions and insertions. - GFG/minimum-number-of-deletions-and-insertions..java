//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

    public int minOps(char[] arr1, char[] arr2, int i, int j,int dp[][]){
        
        if(i==arr1.length || j==arr2.length){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(arr1[i]==arr2[j]){
            return 1+minOps(arr1,arr2,i+1,j+1,dp);
        }
        int arr1CharInclude=minOps(arr1,arr2,i,j+1,dp);
        int arr2CharInclude=minOps(arr1,arr2,i+1,j,dp);
        return dp[i][j]=Math.max(arr1CharInclude,arr2CharInclude);
        
    }
	public int minOperations(String str1, String str2) 
	{ 
	    
	    // Your code goes here
	    
	    int len1=str1.length();
	    int len2=str2.length();
	    int dp[][]=new int[len1][len2];
	    for(int[] arr:dp){
	        Arrays.fill(arr,-1);
	    }
	    int commonCharacter=minOps(str1.toCharArray(),str2.toCharArray(),0,0,dp);
	    int result=0;
	    int deletionRequired=len1-commonCharacter;
	    int insertionrequired=len2-commonCharacter;
	    return result+=deletionRequired+insertionrequired;
	    
	     
	     
	    
	} 
}
