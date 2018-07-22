class Solution {
    public boolean eq(int a,int b,int t)
    {
        long dis=(long)a-(long)b;
        if (dis<0) 
        {
            if(dis>=-t) 
                return true;
            else
                return false;
        }
        else
        {
            if(dis<=t) 
                return true;
            else 
                return false;
        }
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k==0) return false;
        if(k==1)
        {
            for(int i=0;i<nums.length-1;i++)
            {
                if (eq(nums[i],nums[i+1],t)) return true;
            }
            return false;
        }
        int minnum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<minnum) minnum=nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=nums[i]-minnum+t;
        }
        List<List<Integer>> MyHash=new ArrayList<List<Integer>>();
        List<Integer> tmp;
        for(int i=0;i<k;i++)
        {
            tmp=new LinkedList<Integer>();
            MyHash.add(tmp);
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            if(cnt>=k+1)
            {             
                myremove(MyHash,nums[i-k-1],k);
                cnt=cnt-1;
            }

            if(!mycontains(MyHash,nums[i],k,t))
            {
                myadd(MyHash,nums[i],k);
                cnt=cnt+1;
            }
            else
                return true;
        }
        return false;
    }
    
    public void myremove(List<List<Integer>> MyHash,int key,int k)
    {
        List<Integer> tmp;
        tmp=MyHash.get(key%k);
        for(int i=0;i<tmp.size();i++)
        {
            if(tmp.get(i)==key)
            {
                tmp.remove(i);
                break;
            }
        }
        MyHash.set(key%k,tmp);
    }
    
    public void myadd(List<List<Integer>> MyHash,int key,int k)
    {
        List<Integer> tmp;
        tmp=MyHash.get(key%k);
        tmp.add(key);
        MyHash.set(key%k,tmp);
    }
    
    public boolean mycontains(List<List<Integer>> MyHash,int key,int k,int t)
    {
        List<Integer> tmp;
        int start=(key-t)%k;
        int end=(key+t)%k;
        if(t>=k/2)
        {
            for(int j=0;j<=MyHash.size()-1;j++)
            {
                tmp=MyHash.get(j);
                for(int i=0;i<tmp.size();i++)
                {
                    if(eq(key,tmp.get(i),t))
                        return true;
                }                
            }         
        }
        else
        {
            if(start>end)
            {
                for(int j=start;j<MyHash.size();j++)
                {
                    tmp=MyHash.get(j);
                    for(int i=0;i<tmp.size();i++)
                    {
                        if(eq(key,tmp.get(i),t))
                            return true;
                    }                
                }
                for(int j=0;j<=end;j++)
                {
                    tmp=MyHash.get(j);
                    for(int i=0;i<tmp.size();i++)
                    {
                        if(eq(key,tmp.get(i),t))
                            return true;
                    }                
                }
            }
            else
            {
                for(int j=start;j<=end;j++)
                {
                    tmp=MyHash.get(j);
                    for(int i=0;i<tmp.size();i++)
                    {
                        if(eq(key,tmp.get(i),t))
                            return true;
                    }                
                }
            }
        }
        return false;
    }   
}

