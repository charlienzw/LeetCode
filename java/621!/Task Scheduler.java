class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for(int i=0;i<tasks.length;i++)
        {
            map[tasks[i]-'A']++;
        }
        Arrays.sort(map);
        int maxval=map[25]-1;
        int idle_slots=maxval*n;
        for(int i=24;i>=0&&map[i]>0;i--)
        {
            idle_slots=idle_slots-Math.min(map[i],maxval);
        }
        return idle_slots>0?idle_slots+tasks.length:tasks.length;
    }
}