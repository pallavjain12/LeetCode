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
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        java.math.BigInteger a = new java.math.BigInteger("1");
        for (int i = 1; i <= N; i++) {
            a = a.multiply(new java.math.BigInteger(i + ""));
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        String str = a.toString();
        for (int i = 0; i < str.length(); i++) {
            ans.add(str.charAt(i) - '0');
        }
        return ans;
    }
}