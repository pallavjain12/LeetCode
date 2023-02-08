//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine().trim());
        while(T>0)
        {
            String s[]=in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[k][2];
            for(int i=0; i<k; i++){
                s=in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            Solution g = new Solution();
            long[] res = g.countZero(n,k,a);
            
            for(int i=0; i<res.length; i++){
                out.print(res[i]+" ");
            }
            out.println();
            T--;
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    long[] countZero(int n, int k, int[][] a) {
        int rt = 0;
        int ct = 0;
        int re = n * n;
        long[] ans = new long[k];
        int p = 0;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        for (int i = 0; i < k; i++) {
            int r = a[i][0] - 1;
            int c = a[i][1] - 1;
            int temp1 = 0;
            int temp2 = 0;
            if(row[r] == true)
                temp1 = 0;
            else {
                temp1 = n - ct;
                rt++;
                row[r] = true;
            }
            if(col[c] == true) {
                temp2 = 0;
            }
            else {
                ct++;
                temp2 = n - rt;
                col[c] = true;
            }
            re = re - (temp1 + temp2);
            ans[p++] = re;
        }
        return ans;
    }
}