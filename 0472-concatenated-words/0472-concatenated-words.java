class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        for (String s : words) {
            map.put(s, 1);
        }
        for (String s : words) {
            if (checkWord(s, map, 1)) {
                list.add(s);
            }
        }
        return list;
    }
    
    private static boolean checkWord(String s, HashMap<String, Integer> map, int count) {
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i+1);
            if (map.containsKey(temp)) {
                if (i + 1 < s.length()) {
                    if (checkWord(s.substring(i+1), map, count + 1))  return true;
                }
                else {
                    if (count != 1) return true;
                    else return false;
                }
            }
        }
        return false;
    }
}