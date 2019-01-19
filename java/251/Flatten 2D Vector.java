public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iterlist;
    Iterator<Integer> iter;
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d.size() != 0) iterlist = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        while(iter == null || !iter.hasNext())
        {
            if(iterlist == null || !iterlist.hasNext()) return false;
            iter = iterlist.next().iterator();
        }
        return iter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */