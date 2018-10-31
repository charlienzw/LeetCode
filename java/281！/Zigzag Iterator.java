// Time: O(1) O(1) O(k)
// Space: O(1)
public class ZigzagIterator {
    List<List<Integer>> p;
    int cur;
    int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        p = new ArrayList<>();
        p.add(v1);
        p.add(v2);
        cur = 0;
        index = 0;
    }

    public int next() {
        int oldcur = cur;
        cur ++;
        return p.get(oldcur).get(index);
    }

    public boolean hasNext() {
        for(int i = 0; i < 2; i ++)
        {
            while(cur < p.size() && index >= p.get(cur).size())
            {
                cur ++;
            }
            if(cur < p.size()) return true;
            cur = 0;
            index ++;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */