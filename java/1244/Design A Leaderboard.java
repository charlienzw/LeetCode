class Leaderboard {
    Map<Integer, Integer> scoreCnt;
    Map<Integer, Integer> id2Score;
    public Leaderboard() {
        scoreCnt = new TreeMap<>((a, b) -> (b - a));
        id2Score = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        int oldScore = 0;
        if (id2Score.containsKey(playerId)) {
            oldScore = id2Score.get(playerId);
            scoreCnt.put(oldScore, scoreCnt.get(oldScore) - 1); 
        }
        int newScore = oldScore + score;
        id2Score.put(playerId, newScore);
        scoreCnt.put(newScore, scoreCnt.getOrDefault(newScore, 0) + 1);
    }
    
    public int top(int K) {
        int res = 0;
        int i = 0;
        for (Integer score : scoreCnt.keySet()) {
            int cnt = scoreCnt.get(score);
            if (cnt == 0) continue;
            if (i < K) {
                if (i + cnt < K) {
                    res += cnt * score;
                    i += cnt;
                } else {
                    res += (K - i) * score;
                    return res;
                }
            } else {
                return res;
            }
        }
        return res;
    }
    
    public void reset(int playerId) {
        int curScore = id2Score.get(playerId);
        scoreCnt.put(curScore, scoreCnt.get(curScore) - 1);
        id2Score.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */