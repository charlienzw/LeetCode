class Solution {
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0) return s;
        if(numRows==0) return "";
        if(numRows==1) return s;
        List<List<Character>> C=new ArrayList<>();
        for(int i=0;i<numRows;i++) C.add(new ArrayList<>());
        int m=2*numRows-2;
        int index;
        List<Character> tmp;
        for(int i=0;i<s.length();i++)
        {
            index=Math.min(i%m,m-i%m);
            tmp=C.get(index);
            tmp.add(s.charAt(i));
            C.set(index,tmp);
        }
        String res="";
        for(int i=0;i<C.size();i++)
        {
            for(int j=0;j<C.get(i).size();j++)
            {
                res=res+C.get(i).get(j);
            }
        }
        return res;
    }
}