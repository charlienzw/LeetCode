class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int spacelength;
        String tmp="";
        int cur;
        String sp="";
        int split=-1;
        int clear=0;
        int cnt=0;
        int re=0;
        int l;
        String spp="";
        for(int i=0;i<words.length;i++)
        {
            tmp=tmp+words[i];
            cnt++;
            if(tmp.length()>maxWidth)
            {
                cur=0;
                tmp=tmp.substring(0,tmp.length()-words[i].length()-1);
                i--;
                cnt--;
                split=split==-1?i:cnt-1;
                spacelength=maxWidth-tmp.length();
                if(split>0)
                {
                    sp="";
                    for(int k=0;k<spacelength/split;k++)
                    {
                        sp=sp+' ';                               
                    }
                    re=spacelength%split;
                    for(int j=i-cnt+1;j<i-cnt+1+split;j++)
                    {
                        cur=cur+words[j].length()+1;
                        spp=sp;
                        if(re>0) 
                        {
                            spp=spp+' ';
                            re--;
                        }
                        tmp=tmp.substring(0,cur)+spp+tmp.substring(cur);
                        cur=cur+spp.length();
                    }
                }
                else
                {
                    sp="";
                    for(int k=0;k<spacelength;k++) sp=sp+' ';
                    tmp=tmp+sp;
                }
                clear=1;
                res.add(tmp);
            }
            tmp=tmp+' ';
            if(clear==1) 
            {
                tmp="";
                clear=0;
                cnt=0;
            }
        }
        tmp=tmp.substring(0,tmp.length()-1);
        l=tmp.length();
        for(int j=0;j<maxWidth-l;j++) tmp=tmp+' ';
        res.add(tmp);
        return res;
    }
}