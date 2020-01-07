class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (q.size() > 0) {
            int cur = q.poll();
            int front = cur + arr[cur], rear = cur - arr[cur];
            if (front >= 0 && front < arr.length && !visited.contains(front)) {
                if (arr[front] == 0) return true;
                q.add(front);
                visited.add(front);
            }
            if (rear >= 0 && rear < arr.length && !visited.contains(rear)) {
                if (arr[rear] == 0) return true;
                q.add(rear);
                visited.add(rear);
            }
        }
        return false;
    }
}