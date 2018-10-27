//Time:O(1)
//Space:O(1)

class Solution {
    int mindis = Integer.MAX_VALUE;
    String resstr="";
    public String nextClosestTime(String time) {
        HashSet<Integer> set = new HashSet<>();
        set.add(time.charAt(0) - '0');
        set.add(time.charAt(1) - '0');
        set.add(time.charAt(3) - '0');
        set.add(time.charAt(4) - '0');
        Iterator<Integer> iter = set.iterator();
        int[] base = new int[set.size()];
        int i=0;
        while(iter.hasNext())
        {
            base[i++] = iter.next();
        }
        int[] now = new int[]{time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        helper(now, base, 0, new int[4]);
        return resstr;
    }
    
    public void helper(int[] now, int[] base, int cur, int[] temp)
    {
        if(cur==4)
        {
            int disnow=dis(now, temp);
            if(disnow < mindis)
            {
                mindis = disnow;
                resstr = temp[0] + "" + temp[1] + ":" + temp[2] + "" + temp[3];
                
            }
            return;
        }
        for(int i = 0; i < base.length; i ++)
        {
            temp[cur] = base[i];
            helper(now, base, cur + 1, temp);
        }
    }
    
    public int dis(int[] now, int[] temp)
    {
        if(temp[0] == 2 && temp[1] > 3 || temp[0] > 2 || temp[2] >= 6)
            return Integer.MAX_VALUE;
        int nowvalue = (now[0] * 10 + now[1])*60 + now[2] * 10 + now[3];
        int tempvalue = (temp[0] * 10 + temp[1])*60 + temp[2] * 10 + temp[3];
        if(tempvalue > nowvalue)
        {
            return tempvalue - nowvalue;
        }
        else
        {
            return 24*60 - (nowvalue - tempvalue);
        }
    }
}