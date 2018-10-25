// Time:create:O(n*d),sort:O(m+n)
// Space:O(m+n)
// 1.create map one by one, record map and degree
// 2.bfs topological sort
// 3.compare res.length() and degree.length()

class Solution {
    public String alienOrder(String[] words) {
        if(words.length==0) return "";
        StringBuilder sb=new StringBuilder();
        Map<Character,Set<Character>> map=new HashMap<>();
        Map<Character,Integer> degree=new HashMap<>();
        for(String s:words)
        {
            for(int j=0;j<s.length();j++)
            {
                degree.put(s.charAt(j),0);
            }
        }
        Set<Character> tempset;
        for(int i=0;i<words.length-1;i++)
        {
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(),next.length());
            for(int j=0;j<length;j++)
            {
                if(cur.charAt(j)!=next.charAt(j))
                {
                    if(!map.containsKey(cur.charAt(j)))
                    {
                            tempset=new HashSet<>();
                            tempset.add(next.charAt(j));
                            map.put(cur.charAt(j),tempset);
                            degree.put(next.charAt(j),degree.get(next.charAt(j))+1);
                    }
                    else
                    {
                        tempset=map.get(cur.charAt(j));
                        if(!tempset.contains(next.charAt(j)))
                        {
                            tempset.add(next.charAt(j));
                            degree.put(next.charAt(j),degree.get(next.charAt(j))+1);
                        }
                        map.put(cur.charAt(j),tempset);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<>();
        for(char c:degree.keySet())
        {
            if(degree.get(c)==0)
            {
                q.add(c);
            }
        }
        
        while(q.size()>0)
        {
            char c=q.poll();
            sb.append(c);
            if(map.containsKey(c))
            {
                for(char c2:map.get(c))
                {
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            } 
        }
        String res=sb.toString();
        if(res.length()!=degree.size()) return "";
        return res;
    }
}