class MovingAverage {
    int s;
    Queue<Integer> q;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        s = size;
        sum = 0;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        q.add(val);
        sum += val;
        if(q.size() > s)
        {
            int x = q.poll();
            sum -= x;
        }
        return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */