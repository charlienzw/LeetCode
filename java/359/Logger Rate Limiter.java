class Logger {
    Map<Integer, Set<String>> time2Message;
    
    /** Initialize your data structure here. */
    public Logger() {
        time2Message = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean res = true;
        Map<Integer, Set<String>> newTime2Message = new HashMap<>();
        for (int t = timestamp; t >= timestamp - 9; t--) {
            if (!time2Message.containsKey(t)) continue;
            newTime2Message.put(t, time2Message.get(t));
            if (time2Message.get(t).contains(message)) {
                res = false;
            }
        }
        if (res) {
            if (!newTime2Message.containsKey(timestamp)) newTime2Message.put(timestamp, new HashSet<>());
            newTime2Message.get(timestamp).add(message);
        }
        time2Message = newTime2Message;
        return res;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */