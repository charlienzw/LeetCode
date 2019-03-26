class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])) map.put(prerequisites[i][1], new HashSet<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] res = new int[numCourses];
        int count = 0;
        int resi = 0;
        boolean lock = true;
        while(lock) {
            lock = false;
            for(int i = 0; i < numCourses; i++) {
                if(degree[i] == 0) {
                    res[resi++] = i;
                    count++;
                    degree[i] = -1;
                    if(map.containsKey(i)) {
                        for(Integer index : map.get(i))
                            degree[index]--;                        
                    }
                    lock = true;
                }
            }              
        }
        return count == numCourses ? res : new int[0];        
    }
}