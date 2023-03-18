class BrowserHistory {
    static class Node {
        String url;
        Node prev;
        Node next;
    }
    Node head;
    public BrowserHistory(String homepage) {
        Node temp = new Node();
        temp.prev = null;
        temp.next = null;
        temp.url = homepage;
        head = temp;
    }
    
    public void visit(String url) {
        Node temp = new Node();
        temp.url = url;
        temp.prev = head;
        temp.next = null;
        head.next = temp;
        head = temp;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && head.prev != null) {
            head = head.prev;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && head.next != null) {
            head = head.next;
        }
        return head.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */