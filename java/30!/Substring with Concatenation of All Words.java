class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if(words.length==0||s.length()==0) return res;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            map.put(words[i],map.containsKey(words[i])?map.get(words[i])+1:1);
        }
        int n=words.length,m=words[0].length();
        HashMap<String,Integer> tmp;
        int flag;
        String stemp;
        for(int i=0;i<=s.length()-m*n;i++)
        {   
            tmp=new HashMap(map);
            flag=1;
            for(int j=i;j<i+m*n;j=j+m)
            {
                stemp=s.substring(j,j+m);
                if(tmp.containsKey(stemp)&&tmp.get(stemp)>1)
                {
                    tmp.put(stemp,tmp.get(stemp)-1);
                }
                else if(tmp.containsKey(stemp)&&tmp.get(stemp)==1)
                {
                    tmp.remove(stemp);
                }
                else
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                res.add(i);
            }
        }
        return res;
    }
}