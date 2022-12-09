//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    static long numOfWays(int N, int M)
    {
        long ans=0L;
        long mod=1000000007;
        int[][]dirs=new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                long total=N*M;
                long minus=1L;
                for(int[] d: dirs){
                  if(isValid(i+d[0],j+d[1],N,M)) minus++;    
                }
                total-=minus;
                ans=(ans+total)%mod;
            }
        }
        return ans%mod;
    }
    public static boolean isValid(int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
}
// class BlackAndWhite {
//     static long numOfWays(int N, int M){
//         long count = 0L;
//         if (N * M == 1) return 0;
//         for(int i = 0; i < N; i++) {
//             for(int j = 0 ; j < M; j++) {
//                 count += check(i, j, N, M);
//                 count %= 1000000007;
//             }
//         }
//         return count;
//     }
//     static int check(int i, int j, int n, int m) {
//         System.out.println(n);
//         System.out.println(m);
//         int count = ((n * m) - 1);
//         count -= (valid(i + 1, j + 2, n, m)) ? -1 : 0;
//         count -= (valid(i + 1, j - 2, n, m)) ? -1 : 0;
//         count -= (valid(i - 1, j + 2, n, m)) ? -1 : 0;
//         count -= (valid(i - 1, j - 2, n, m)) ? -1 : 0;

//         count -= (valid(i + 2, j + 1, n, m)) ? -1 : 0;
//         count -= (valid(i - 2, j + 1, n, m)) ? -1 : 0;
//         count -= (valid(i + 2, j - 1, n, m)) ? -1 : 0;
//         count -= (valid(i - 2, j - 1, n, m)) ? -1 : 0;
//         System.out.println("i : " + i + " j " + j + " count " + count);
//         return count;
//     }
//     static boolean valid(int i, int j, int n, int m) {
//         if (i < 0 || i >= n)    return false;
//         if (j < 0 || j >= m)    return false;
//         return true;
//     }
//}