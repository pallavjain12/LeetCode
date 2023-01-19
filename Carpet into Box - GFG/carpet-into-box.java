//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int a, int b, int c, int d) { 
        return check(a, b, c, d);
    }
    private static int check(int a, int b, int c, int d) {
        if (Math.max(a, b) > Math.max(c, d))    return 1 + check(Math.max(a, b) / 2, Math.min(a, b), c, d);
        else if (Math.min(a, b) > Math.min(c, d))   return 1 + check(Math.max(a, b), Math.min(a, b) / 2, c, d);
        else return 0;
    }
}
