class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/", 0);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.length() == 0) continue;
            if (dotCount(temp) == 1 && temp.length() == 1) {
                continue;
            }
            else if (dotCount(temp) == 2 && temp.length() == 2) {
                if (list.size() > 0) list.remove(list.size() - 1);
            }
            else {
                list.add(temp);
            }
        }
        String string = "/";
        for(int i = 0; i < list.size(); i++) {
            string += list.get(i);
            if (i != list.size() - 1) string += "/";
        }
        return string;
    }
    static int dotCount(String temp) {
        int count = 0;
        for (int i = 0 ; i < temp.length(); i++) {
            if (temp.charAt(i) == '.') count += 1;
        }
        return count;
    }
}