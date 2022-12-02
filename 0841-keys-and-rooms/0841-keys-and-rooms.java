class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int allRooms = rooms.size();
        Set<Integer> set = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        set.add(0);
        while (!stack.isEmpty() && set.size() != allRooms) {
            List<Integer> currentRoom = new ArrayList<Integer>(rooms.get(stack.pop()));
            for (int i = 0; i < currentRoom.size(); i++) {
                if (!set.contains(currentRoom.get(i))) {
                    stack.push(currentRoom.get(i));
                    set.add(currentRoom.get(i));
                }
            }
        }
        Integer max = (int)Collections.max(set);
        if (set.size() == rooms.size()) return true;
        else return false;
    }
}