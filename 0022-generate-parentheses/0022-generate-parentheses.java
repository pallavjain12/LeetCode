class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        int allBrackets = n * 2;
        print("", allBrackets, n, 0, list);
        return list;
    }
    public static void print(String str, int allBrackets, int pair, int open, ArrayList<String> list) {
        if (open == 0 && pair != 0) {
            print(str + "(", allBrackets - 1, pair - 1, open + 1, list);
        }
        else if (allBrackets == 0) {
            list.add(str);
            return;
        }
        else {
            if (pair != 0) {
                print(str + "(", allBrackets - 1, pair - 1, open + 1, list);
            }
            print(str + ")", allBrackets - 1, pair, open - 1, list);
        }
    }
}