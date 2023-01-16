class Solution {
    static class pair{
        int start;
        int end;
        pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] insert(int[][] arr, int[] add) {
        if (arr.length == 0)    return new int[][]{{add[0], add[1]}};
        int counter = 0;
        int index = 0;
        int[][] ans = new int[arr.length + 1][2];
        boolean check = true;
        while (index < arr.length && check) {
            if (arr[index][0] < add[0]) {
                ans[counter][0] = arr[index][0];
                ans[counter++][1] = arr[index++][1];
            }
            else {
                ans[counter][0] = add[0];
                ans[counter++][1] = add[1];
                check = false;
            }
        }
        while(index < arr.length) {
            ans[counter][0] = arr[index][0];
            ans[counter++][1] = arr[index++][1];
        }
        if (check) {
            ans[counter][0] = add[0];
            ans[counter][1] = add[1];
        }
        
        
        // solving ans arranging
        ArrayList<pair> list = new ArrayList<pair>();
        list.add(new pair(ans[0][0], ans[0][1]));
        for(int i = 1; i < ans.length; i++) {
            pair old = list.get(list.size() - 1);
            pair neww = new pair(ans[i][0], ans[i][1]);
            if (old.end < neww.start) {
                list.add(neww);
                continue;
            }
            else {
                old.end = Math.max(old.end, neww.end);
            }
        }
        counter = 0;
        int[][] ret = new int[list.size()][2];
        for (pair i : list) {
            ret[counter][0] = i.start;
            ret[counter++][1] = i.end;
        }
        return ret;
    }
}