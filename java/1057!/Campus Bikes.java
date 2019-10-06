class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[][] pairs = new int[workers.length * bikes.length][2];
        int k = 0;
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                pairs[k++] = new int[] {i, j};
            }
        }
        
        bucketSort(pairs, workers, bikes);
        
        int[] res = new int[workers.length];
        Set<Integer> occupied = new HashSet<>();
        Set<Integer> assigned = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            int worker = pairs[i][0], bike = pairs[i][1];
            if (!occupied.contains(worker) && !assigned.contains(bike)) {
                res[worker] = bike;
                occupied.add(worker);
                assigned.add(bike);
            }
        }
        return res;
    }
    
    private void bucketSort(int[][] pairs, int[][] workers, int[][] bikes) {
        List<int[]>[] list = new List[2001];
        for (int i = 0; i < pairs.length; i++) {
            int distance = Math.abs(workers[pairs[i][0]][0] - bikes[pairs[i][1]][0]) + Math.abs(workers[pairs[i][0]][1] - bikes[pairs[i][1]][1]);
            if (list[distance] == null) {
                list[distance] = new ArrayList<>();
            }
            list[distance].add(pairs[i]);
        }
        int k = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                for (int j = 0; j < list[i].size(); j++) {
                    pairs[k++] = list[i].get(j);
                }
            }
        }
    }
}