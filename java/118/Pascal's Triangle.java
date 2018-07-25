class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows==0) return res;
        List<Integer> tmp=new ArrayList<Integer>();
        List<Integer> tmpnext;
        for(int i=0;i<numRows;i++)
        {
            if(i==0)
            {
                tmp=new ArrayList<Integer>();
                tmp.add(1);
            }
            else
            {
                tmpnext=new ArrayList<Integer>();
                tmpnext.add(1);
                for(int j=0;j<tmp.size()-1;j++)
                {
                    tmpnext.add(tmp.get(j)+tmp.get(j+1));
                }
                tmpnext.add(1);
                tmp=tmpnext;
            }
            res.add(tmp);
        }
        return res;
    }
}