class RandomizedSet {
    Set<Integer> set;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        else
        {
            set.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        else
        {
            set.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int k = rand.nextInt(set.size());
        Iterator<Integer> iter = set.iterator();
        int cnt = 0;
        while(iter.hasNext())
        {
            if(cnt == k)
            {
                return iter.next();
            }
            else
            {
                cnt++;
                iter.next();
            }
        }
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */