class RandomizedCollection {
    HashMap<Integer, Integer> map;
    Random random;
    ArrayList<Integer> list;
    public RandomizedCollection() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        list.add(val);
        if (map.get(val) == 1)  return true;
        return false;
    }
    
    public boolean remove(int val) {
        map.put(val, map.getOrDefault(val, 0) - 1);
        if (map.get(val) == -1) {
            map.remove(val);
            return false;
        }
        list.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */