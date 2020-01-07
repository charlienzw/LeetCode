class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(id);
        visited.add(id);
        int curLevel = 0;
        List<Integer> objFriends = new ArrayList<>();
        while(q.size() > 0 && curLevel < level) {
            int qSize = q.size();
            objFriends = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                int cur = q.poll();
                for (int friend : friends[cur]) {
                    if (!visited.contains(friend)) {
                        q.add(friend);
                        visited.add(friend);
                        objFriends.add(friend);
                    }
                }
            }
            curLevel++;
        }
        Set<String> resSet = new HashSet<>();
        Map<String, Integer> resMap = new HashMap<>();
        for (Integer friend : objFriends) {
            List<String> videos = watchedVideos.get(friend);
            for (String video : videos) {
                resSet.add(video);
                resMap.put(video, resMap.getOrDefault(video, 0) + 1);
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : resSet) res.add(s);
        Collections.sort(res, (a, b) -> (resMap.get(a) != resMap.get(b) ? resMap.get(a) - resMap.get(b) : a.compareTo(b)));
        return res;
    }
}