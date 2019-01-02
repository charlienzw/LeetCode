class MinStack {
    Deque<Integer> stack;
    Deque<Integer> ms;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        ms = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(ms.size() == 0)
        {
           ms.push(x);
        }
        else
        {
            ms.push(Math.min(x, ms.peek()));
        }
    }
    
    public void pop() {
        if(stack.size() > 0)
        {
            stack.pop();
            ms.pop();
        }  
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */