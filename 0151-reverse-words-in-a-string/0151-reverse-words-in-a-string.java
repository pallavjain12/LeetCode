import java.util.*;
class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int n = st.countTokens();
        String[] arr = new String[n];
        for (int i = n-1 ; i >= 0; i--) {
            arr[i] = st.nextToken();
        }
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < n; i++) {
            temp.append(arr[i]);
            if(i != n-1) {
                temp.append(" ");
            }
        }
        return temp.toString();
    }
}