class Solution {
    public int myAtoi(String str) {
        if(str.length()==0) return 0;
        int start=-1,end=-1;
        for(int i=0;i<str.length();i++)
        {
            if(start!=-1&&str.charAt(i)==' ') 
            {
                end=i-1;
                break;
            }
            if(start==-1&&str.charAt(i)!=' ') start=i;
        }
        if(end==-1) end=str.length()-1;
        if(start==-1) return 0;
        int neg=0;
        int num=0;
        if(start<=end)
        {
            if(str.charAt(start)=='+') start++;
            else if(str.charAt(start)=='-') 
            {
                start++;
                neg=1;
            }
            for(int i=start;i<=end;i++)
            {
                if(str.charAt(i)<='9'&&str.charAt(i)>='0')
                {
                    if(neg==0&&num>(Integer.MAX_VALUE-(str.charAt(i)-'0'))/10) return Integer.MAX_VALUE;
                    if(neg==1&&num>(-1)*((Integer.MIN_VALUE+(str.charAt(i)-'0'))/10)) return Integer.MIN_VALUE;
                    num=num*10+(str.charAt(i)-'0');
                }
                else
                {
                    if(neg==0) return num;
                    else return (-1)*num;   
                }
            }
            if(neg==0) return num;
            else return (-1)*num;
        }
        return 0;       
    }
}