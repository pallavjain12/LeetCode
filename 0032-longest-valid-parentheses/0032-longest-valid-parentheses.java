class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int openInStack = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(-1);
                openInStack += 1;
            }
            else {
                if (openInStack == 0) {
                    stack.push(-2);
                }
                else {
                    int sum = 2;
                    while(stack.peek() != -1) {
                        sum += stack.pop();
                    }
                    stack.pop();
                    stack.push(sum);
                    openInStack -= 1;
                }
            }
        }
        int max = 0;
        while(!stack.isEmpty()) {
            int temp = 0;
            while(!stack.isEmpty() && stack.peek() != -2 && stack.peek() != -1) {
                temp += stack.pop();
            }
            max = Math.max(max, temp);
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return max;
    }
}