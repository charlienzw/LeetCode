class Solution {
    public String multiply(String num1, String num2) {
        String r="";
        int[] res=new int[num1.length()+num2.length()];
        int s,mul;
        for(int i=num1.length()-1;i>=0;i--)
        {
            for(int j=num2.length()-1;j>=0;j--)
            {
                s=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                s=s+res[i+j+1];
                res[i+j]=res[i+j]+s/10;
                res[i+j+1]=s%10;
            }

        }
        for(int i=0;i<res.length;i++)
        {
            if(!(r.length()==0&&res[i]==0)) r=r+res[i];
        }
        if(r.length()==0) return "0";
        else return r;
    }
}