class WordDictionary {
    static class node {
        node[] nodes;
        boolean end;
        node() {
            nodes = new node[27];
            Arrays.fill(nodes, null);
            end = false;
        }
    }
    
    node main;
    public WordDictionary() {
        node temp = new node();
        main = temp;
    }
    
    public void addWord(String word) {
        node itr = main;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (itr.nodes[c - 'a'] != null) {
                itr = itr.nodes[c - 'a'];
            }
            else {
                node temp = new node();
                itr.nodes[c - 'a'] = temp;
                itr = temp;
            }
            if (i == word.length() - 1) {
                itr.end = true;
            }
        }
    }
    
    public boolean search(String word) {
        return findWord(main, 0, word);
    }
    
    private boolean findWord(node itr, int index, String word) {
        if (word.length() == index && itr.end)  return true;
        if (word.length() == index) return false;
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (itr.nodes[i] != null) {
                    if (findWord(itr.nodes[i], index + 1, word))
                        return true;
                }
            }
        }
        else {
            if (itr.nodes[word.charAt(index) - 'a'] == null) {
                return false;
            }
            else {
                return findWord(itr.nodes[word.charAt(index) - 'a'], index + 1, word);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */