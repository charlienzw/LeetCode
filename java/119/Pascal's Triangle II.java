class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<Integer>();
        List<Integer> tmp=new ArrayList<Integer>();
        int sizenow;
        for(int i=0;i<=rowIndex;i++)
        {
            if(i==0)
            {
                tmp=new ArrayList<Integer>();
                tmp.add(1);
            }
            else if(i==1)
            {
                tmp.add(1);
            }
            else
            {
                sizenow=tmp.size();
                for(int j=0;j<sizenow-1;j++)
                {
                    tmp.add(tmp.get(j)+tmp.get(j+1));
                }
                for(int j=sizenow-1;j>=1;j--)
                {
                    tmp.remove(j);
                }
                tmp.add(1);
                
            }
        }
        return tmp;        
    }
}