class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> deadset = new HashSet<>();
        int step = 0;
        for(int i = 0; i < deadends.length; i++)
        {
            deadset.add(deadends[i]);
        }
        if(deadset.contains("0000")) return -1;
        q.add("0000");
        set.add("0000");
        String temp, tempnew;
        while(q.size() > 0)
        {
            int qsize = q.size();
            step++;
            for(int j = 0; j < qsize; j++)
            {
                temp = q.poll();
                for(int i = 0; i < temp.length(); i++)
                {
                    tempnew = temp.substring(0, i) + (temp.charAt(i) != '9' ? (char)((int)temp.charAt(i) + 1) : '0') + temp.substring(i + 1);
                    if(tempnew.equals(target))
                        return step;
                    if(!set.contains(tempnew) && !deadset.contains(tempnew))
                    {
                        q.add(tempnew);
                        set.add(tempnew);
                    }
                    tempnew = temp.substring(0, i) + (temp.charAt(i) != '0' ? (char)((int)temp.charAt(i) - 1) : '9') + temp.substring(i + 1);  
                    if(tempnew.equals(target))
                        return step;
                    if(!set.contains(tempnew) && !deadset.contains(tempnew))
                    {
                        q.add(tempnew);
                        set.add(tempnew);
                    }                    
                }
            }
        }
        return -1;
    }
}