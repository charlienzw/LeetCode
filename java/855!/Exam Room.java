

class ExamRoom {
    int length;
    PriorityQueue<Slot> pq;
    class Slot {
        int start;
        int end;
        int dis;
        public Slot(int start, int end) {
            this.start = start;
            this.end = end;
            if (start == 0) this.dis = end;
            else if (end == length) this.dis = length - start;
            else this.dis = (end - start + 1) / 2;
        }
    }
    
    
    public ExamRoom(int N) {
        pq = new PriorityQueue<>((a, b) -> a.dis != b.dis ? b.dis - a.dis : a.start - b.start);
        length = N;
        pq.add(new Slot(0, N));
    }
    
    public int seat() {
        if (length == 1) return 0;
        
        Slot slot = pq.poll();
        if (slot.start == slot.end - 1) {
            return slot.start;
        }
        
        if (slot.start == 0) {
            if (1 < slot.end) pq.add(new Slot(1, slot.end));
            return 0;
        }
        if (slot.end == length) {
            if (slot.start < length - 1) pq.add(new Slot(slot.start, length - 1));
            return length - 1;
        }
        int mid = (slot.start + slot.end - 1) / 2;
        if (slot.start < mid) pq.add(new Slot(slot.start, mid));
        if (mid + 1 < slot.end) pq.add(new Slot(mid + 1, slot.end));
        return mid;
    }
    
    public void leave(int p) {
        if (length == 1) return;
        List<Slot> list = new ArrayList<>(pq);
        Slot head = null, tail = null;
        for (Slot s : list) {
            if (s.end == p) {
                head = s;
            } else if (s.start == p + 1) {
                tail = s;
            }
        }
        if (head == null && tail == null) {
            pq.add(new Slot(p, p + 1));
            return;
        }
        
        if (head == null) {
            pq.remove(tail);
            pq.add(new Slot(p, tail.end));
            return;
        }
        if (tail == null) {
            pq.remove(head);
            pq.add(new Slot(head.start, p + 1));
            return;
        }
        pq.remove(head);
        pq.remove(tail);
        pq.add(new Slot(head.start, tail.end));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */