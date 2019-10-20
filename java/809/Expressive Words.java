class Segment {
    char c;
    int length;
    public Segment(char c, int length) {
        this.c = c;
        this.length = length;
    }
}

class Solution {
    public int expressiveWords(String S, String[] words) {
        List<Segment> segments = createSegments(S);
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if(isStretchy(segments, words[i])) res++;
        }
        return res;
    }
    
    private boolean isStretchy(List<Segment> segments, String s) {
        List<Segment> objSegments = createSegments(s);
        if (segments.size() != objSegments.size()) return false;
        for (int i = 0; i < segments.size(); i++) {
            Segment seg = segments.get(i), objSeg = objSegments.get(i);
            if (seg.c != objSeg.c || seg.length < objSeg.length || seg.length != objSeg.length && seg.length < 3) return false;
        }
        return true;
    }
    
    private List<Segment> createSegments(String s) {
        List<Segment> segments = new ArrayList<>();
        if (s.length() == 0) return segments;
        char pre = s.charAt(0);
        int curLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                curLen++;
            } else {
                segments.add(new Segment(pre, curLen));
                curLen = 1;
                pre = s.charAt(i);
            }
        }
        segments.add(new Segment(pre, curLen));
        return segments;
    }
}