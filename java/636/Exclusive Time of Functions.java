class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        int[] res = new int[n];
        int lastTime = -1;
        for(int i = 0; i < logs.size(); i++) {
            String[] splitLog = logs.get(i).split(":");
            int curIndex = Integer.valueOf(splitLog[0]);
            int curTime = Integer.valueOf(splitLog[2]);
            if(splitLog[1].equals("start")) {
                if(s1.size() > 0) res[s1.peek()] += curTime - lastTime;
                lastTime = curTime;
                s1.push(curIndex);
                s2.push(curTime);
            } else {
                res[curIndex] += curTime - lastTime + 1;
                lastTime = curTime + 1;
                s2.pop();
                s1.pop();
            }
        }
        return res;
    }
}