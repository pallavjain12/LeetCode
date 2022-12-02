class Solution {
    public List<String> wordBreak(String s, List<String> words) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < words.size(); i++) {
            set.add(words.get(i));
        }
        List<String> list = new ArrayList<String>();
        solve(set, 0, s, "", list);
        return list;
    }
    private static void solve(Set<String> set, int startIndex, String mainString, String partialString, List<String> list) {
        if (startIndex == mainString.length()) {
            list.add(partialString.trim());
        }
        String currentString = "";
        for(int i = startIndex; i < mainString.length(); i++) {
            currentString = currentString + mainString.charAt(i);
            if (set.contains(currentString)) {
                solve(set, i + 1, mainString, partialString + currentString + " ", list);
            }
        }
    }
}