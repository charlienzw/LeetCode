class valueTimePair {
    String value;
    int time;
    public valueTimePair(String value, int time) {
        this.value = value;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<valueTimePair>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new valueTimePair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<valueTimePair> list = map.get(key);
        int index = binarySearch(list, timestamp);
        return index == -1 ? "" : list.get(index).value;
    }
    
    private int binarySearch(List<valueTimePair> list, int t) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).time <= t) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == list.size() - 1 && list.get(low).time <= t) return low;
        return low - 1;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */