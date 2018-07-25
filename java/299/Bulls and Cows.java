class Solution {
    public String getHint(String secret, String guess) {
        int n=secret.length();
        int[] cnt=new int[10];
        int[] cnt1=new int[10];
        int[] cnt2=new int[10];
        for(int i=0;i<=9;i++)
        {
            cnt[i]=cnt1[i]=cnt2[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
            {
                cnt[secret.charAt(i)-'0']++;
            }
            cnt1[secret.charAt(i)-'0']++;
            cnt2[guess.charAt(i)-'0']++;
        }
        int res1=0;
        int res2=0;
        for(int i=0;i<=9;i++)
        {
            res1=res1+cnt[i];
            if(cnt1[i]<cnt2[i])
            {
                res2=res2+cnt1[i]-cnt[i];
            }
            else
            {
                res2=res2+cnt2[i]-cnt[i];   
            }
        }
        String res="";
        res=res+res1+"A"+res2+"B";
        return res;
    }
}