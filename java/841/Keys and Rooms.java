class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        int temp;
        while(q.size() > 0)
        {
            temp = q.poll();
            for(int i = 0; i < rooms.get(temp).size(); i++)
            {
                int tempkey = rooms.get(temp).get(i);
                if(!visited.contains(tempkey))
                {
                    visited.add(tempkey);
                    q.add(tempkey);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}