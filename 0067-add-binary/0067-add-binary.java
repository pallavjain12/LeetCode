class Solution {
    public String addBinary(String aa, String bb) {
        boolean carry = false;
        int i = 0;
        StringBuilder ans = new StringBuilder();
        StringBuilder temp1 = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        temp1.append(aa);
        temp2.append(bb);
        aa = temp1.reverse().toString();
        bb = temp2.reverse().toString();
        for (i = 0; i < Math.max(aa.length(), bb.length()); i++) {
            char a = (i < aa.length()) ? aa.charAt(i) : '0';
            char b = (i < bb.length()) ? bb.charAt(i) : '0';
            if (a == '1' && b == '1') {
                if (carry) {
                    ans.append("1");
                    carry = true;
                }
                else {
                    carry = true;
                    ans.append("0");
                }
            }
            else if (a == '1' && b == '0'){
                if (carry) {
                    carry = true;
                    ans.append("0");
                }
                else {
                    carry = false;
                    ans.append("1");
                }
            }
            else if (a == '0' && b == '1'){
                if (carry) {
                    carry = true;
                    ans.append("0");
                }
                else {
                    carry = false;
                    ans.append("1");
                }
            }
            else {
                if(carry) {
                    carry = false;
                    ans.append("1");
                }
                else {
                    carry = false;
                    ans.append("0");
                }
            }
        }
        if (carry) {
            ans.append("1");
        }
        return ans.reverse().toString();
    }
}