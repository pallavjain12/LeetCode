class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, Integer> map = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
            for (int j = 0; j < current.length(); j++) {
                char c = current.charAt(j);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            if(map.containsKey(freqMap)) {
                list.get(map.get(freqMap)).add(current);
            }
            else {
                map.put(freqMap, counter);
                ArrayList<String> temp = new ArrayList<>();
                temp.add(current);
                list.add(temp);
                counter += 1;
            }
        }
        return list;
    }
}