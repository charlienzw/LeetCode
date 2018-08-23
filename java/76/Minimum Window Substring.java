class Solution {
    public String minWindow(String s, String t) {
        if(s==""||t=="") return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            if(!map.containsKey(t.charAt(i)))
            {
                map.put(t.charAt(i),1);
            }
            else
            {
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }
        }
        int minlen=Integer.MAX_VALUE;
        int minstart=-1;
        Queue<Integer> q=new LinkedList<>();
        HashMap<Character,Integer> copymap=new HashMap<>(map);
        for(int i=0;i<s.length();i++)
        {
            if(copymap.containsKey(s.charAt(i)))
            {
                q.add(i);
                if(map.size()>0)
                {
                    copymap.put(s.charAt(i),copymap.get(s.charAt(i))-1);
                    if(map.containsKey(s.charAt(i)))
                    {
                        if(map.get(s.charAt(i))>1) map.put(s.charAt(i),map.get(s.charAt(i))-1);
                        else map.remove(s.charAt(i));
                    }
                    if(map.size()==0)
                    {
                        if(i-q.peek()+1<minlen)
                        {
                            minlen=i-q.peek()+1;
                            minstart=q.peek();
                        }
                        while(copymap.get(s.charAt(q.peek()))<0)
                        {
                            copymap.put(s.charAt(q.peek()),copymap.get(s.charAt(q.peek()))+1);
                            q.remove();
                            if(i-q.peek()+1<minlen)
                            {
                                minlen=i-q.peek()+1;
                                minstart=q.peek();
                            }
                        }
                    }
                }
                else
                {
                    copymap.put(s.charAt(i),copymap.get(s.charAt(i))-1);
                    while(copymap.get(s.charAt(q.peek()))<0)
                    {
                        copymap.put(s.charAt(q.peek()),copymap.get(s.charAt(q.peek()))+1);
                        q.remove();
                        if(i-q.peek()+1<minlen)
                        {
                            minlen=i-q.peek()+1;
                            minstart=q.peek();
                        }
                    }
                }    
            }
        }
        if(minstart==-1) return "";
        return s.substring(minstart,minstart+minlen);
    }
}