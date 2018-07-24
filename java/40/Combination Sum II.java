class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0) return result;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<candidates.length;i++)
        {
            set.add(candidates[i]);
        }
        Iterator<Integer> iter= set.iterator();
        int val;
        int cnti;
        int[] candidatesset=new int[set.size()];
        int index1=0;
        int index2=0;
        int[] cnt=new int[set.size()];
        while(iter.hasNext())
        {
            val=iter.next();
            candidatesset[index1]=val;
            index1++;
            cnti=0;
            for(int i=0;i<candidates.length;i++)
            {
                if(candidates[i]==val)
                {
                    cnti++;
                }
            }
            cnt[index2]=cnti;
            index2++;
            
        }
        fun(candidatesset,cnt,target,result,new ArrayList<Integer>(),0);
        return result;
    }

    public void fun(int[] candidatesset,int[] cnt,int target,List<List<Integer>> result,List<Integer> tmp,int cur)
    {
        if(target<0) return;
        if(target==0)
        {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=cur;i<candidatesset.length;i++)
        {
            if(cnt[i]>0)
            {
                tmp.add(candidatesset[i]);
                cnt[i]=cnt[i]-1;
                fun(candidatesset,cnt,target-candidatesset[i],result,tmp,i);
                tmp.remove(tmp.size()-1);
                cnt[i]=cnt[i]+1;
            }
        }
    }
}