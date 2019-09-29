class Solution {
    class Segment {
        char key;
        int cnt;
        public Segment(char key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == s.charAt(i - 1)) {
                segments.get(segments.size() - 1).cnt++;
            } else {
                segments.add(new Segment(s.charAt(i), 1));
            }
        }
        
        for (int i = segments.size() - 1; i >= 0; i--) {
            if (segments.get(i).cnt >= k) {
                segments.get(i).cnt = segments.get(i).cnt % k;
                if (segments.get(i).cnt > 0) continue;
                segments.remove(i);
                if (i < segments.size() && i > 0 && segments.get(i).key == segments.get(i - 1).key) {
                    segments.get(i - 1).cnt += segments.get(i).cnt;
                    segments.remove(i);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < segments.size(); i++) {
            for (int j = 0; j < segments.get(i).cnt; j++) {
                sb.append(segments.get(i).key);
            }
        }
        return sb.toString();
    }
}