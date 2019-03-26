// Time; O(nlogK)
// Space: O(K) or O(n)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] dis = new int[points.length][2];
        for(int i = 0; i < points.length; i++) {
            dis[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            dis[i][1] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[0] - b[0];});
        for(int i = 0; i < dis.length; i++) {
            pq.add(dis[i]);
        }
        int[][] res = new int[K][2];
        int index = 0;
        for(int i = 0; i < K; i++) {
            int[] temp = pq.poll();
            res[index++] = points[temp[1]];
        }
        return res;
    }
}


// Time: O(n) in average
// Space: O(n)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        sortFirstK(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void sortFirstK(int[][] points, int low, int high, int K) {
        if(low >= high) return;
        Random rand = new Random();
        int selectedIndex = rand.nextInt(high - low + 1);
        swap(points, low + selectedIndex, high);
        int pivot = patition(points, low, high);
        int leftLength = pivot - low + 1;
        if(leftLength < K) {
            sortFirstK(points, pivot + 1, high, K - leftLength);
        }
        else {
            sortFirstK(points, low, pivot - 1, K);
        }
    }
    
    private int patition(int[][] points, int low, int high) {
        int x = dis(points[high]);
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(dis(points[j]) < x) {
                i++;
                swap(points, i, j);
            }
        }
        swap(points, i + 1, high);
        return i + 1;
    }
    
    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int temp;
        temp = points[i][0];
        points[i][0] = points[j][0];
        points[j][0] = temp;
        temp = points[i][1];
        points[i][1] = points[j][1];
        points[j][1] = temp;
    }
}