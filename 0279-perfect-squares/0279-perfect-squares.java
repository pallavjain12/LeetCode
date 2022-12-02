class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        int table[] = new int[n + 1];
        table[0] = 0;
        for (int i = 1; i <= n; i++)
            table[i] = Integer.MAX_VALUE;
 
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list.size(); j++)
                if (list.get(j) <= i) {
                    int sub_res = table[i - list.get(j)];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;     
            }
        }
        if(table[n]==Integer.MAX_VALUE)
            return -1;
        return table[n];
    }
}