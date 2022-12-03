class Solution {
    class pair implements Comparable<pair> {
        char ch;
        int count;
        public pair(char c) {
            this.ch = c;
            this.count = 0;
        }
        public char getChar() {
            return ch;
        }
        public int getCount() {
            return count;
        }
        public void increase() {
            count += 1;
        }
        public int compareTo(pair b) {
            if (this.getCount() > b.getCount()) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, pair> map = new HashMap<Character, pair>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.get(c).increase();
            else {
                pair obj = new pair(c);
                obj.increase();
                map.put(c, obj);
            }
        }
        // for (Map.Entry<Character, pair> mp : map.entrySet()) {
        //     System.out.println(mp.getKey() + " " + mp.getValue().getCount());
        // }
        String res = "";
        List<pair> list = new ArrayList<pair>(map.values());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i += 1) {
            char ch = list.get(i).getChar();
            int count = list.get(i).getCount();
            while (count != 0) {
                res += ch;
                count -= 1;
            }
        }
        return res;
    }
}