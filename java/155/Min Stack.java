class MinStack {
    StackNode head;
    StackNode top;
    class StackNode{
        int val;
        StackNode next;
        public StackNode(int v){val=v;}
    }
    /** initialize your data structure here. */
    public MinStack() {
        head=new StackNode(0);
        top=head;
    }
    
    public void push(int x) {
        StackNode p=new StackNode(x);
        top.next=p;
        top=top.next;
    }
    
    public void pop() {
        StackNode p=head;
        while(p.next!=top)
        {
            p=p.next;
        }
        top=p;
        top.next=null;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        int minnum=Integer.MAX_VALUE;
        StackNode p=head;
        while(p!=top)
        {
            p=p.next;
            minnum=Math.min(minnum,p.val);
        }
        return minnum;
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