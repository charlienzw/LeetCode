class Solution {
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int b=num/1000000000;
        int m=num%1000000000/1000000;
        int t=num%1000000000%1000000/1000;
        int n=num%1000;
        String res="";
        if(b!=0)
        {
            if(m!=0)
            {
                if(t!=0)
                {
                    if(n!=0) res=res+helper(b)+" "+"Billion"+" "+helper(m)+" "+"Million"+" "+helper(t)+" "+"Thousand"+" "+helper(n);
                    else res=res+helper(b)+" "+"Billion"+" "+helper(m)+" "+"Million"+" "+helper(t)+" "+"Thousand";
                }
                else
                {
                    if(n!=0) res=res+helper(b)+" "+"Billion"+" "+helper(m)+" "+"Million"+" "+helper(n);
                    else res=res+helper(b)+" "+"Billion"+" "+helper(m)+" "+"Million";
                }
            }
            else
            {
                if(t!=0)
                {
                    if(n!=0) res=res+helper(b)+" "+"Billion"+" "+helper(t)+" "+"Thousand"+" "+helper(n);
                    else res=res+helper(b)+" "+"Billion"+" "+helper(t)+" "+"Thousand";     
                }
                else
                {
                    if(n!=0) res=res+helper(b)+" "+"Billion"+" "+helper(n);
                    else res=res+helper(b)+" "+"Billion";
                }                
            }       
        }
        else
        {
            if(m!=0)
            {
                if(t!=0)
                {
                    if(n!=0) res=res+helper(m)+" "+"Million"+" "+helper(t)+" "+"Thousand"+" "+helper(n);
                    else res=res+helper(m)+" "+"Million"+" "+helper(t)+" "+"Thousand";
                }
                else
                {
                    if(n!=0) res=res+helper(m)+" "+"Million"+" "+helper(n);
                    else res=res+helper(m)+" "+"Million";
                }
            }
            else
            {
                if(t!=0)
                {
                    if(n!=0) res=res+helper(t)+" "+"Thousand"+" "+helper(n);
                    else res=res+helper(t)+" "+"Thousand";   
                }
                else
                {
                    res=res+helper(n);
                }                
            }             
        }
        return res;
    }
    public String helper(int n)
    {
        if(n/100!=0)
        {
            if(n%100/10==0)
            {
                if(n%10==0) return int2one(n/100)+" "+"Hundred";
                else return int2one(n/100)+" "+"Hundred"+" "+int2one(n%10);
            }
            else if(n%100/10==1)
            {
                return int2one(n/100)+" "+"Hundred"+" "+int2tens(n%10);
            }
            else
            {
                if(n%10==0) return int2one(n/100)+" "+"Hundred"+" "+int2ten(n%100/10);
                else return int2one(n/100)+" "+"Hundred"+" "+int2ten(n%100/10)+" "+int2one(n%10);
                
            }
        }
        else
        {
            if(n%100/10==0)
            {
                if(n%10==0) return "";
                else return int2one(n%10);
            }
            else if(n%100/10==1)
            {
                return int2tens(n%10);
            }
            else
            {
                if(n%10==0) return int2ten(n%100/10);
                else return int2ten(n%100/10)+" "+int2one(n%10);  
            }       
        }
    }
    public String int2one(int n)
    {
        if(n==1) return "One";
        if(n==2) return "Two";
        if(n==3) return "Three";
        if(n==4) return "Four";
        if(n==5) return "Five";
        if(n==6) return "Six";
        if(n==7) return "Seven";
        if(n==8) return "Eight";
        if(n==9) return "Nine";
        return "";
    }
    public String int2ten(int n)
    {
        if(n==2) return "Twenty";
        if(n==3) return "Thirty";
        if(n==4) return "Forty";
        if(n==5) return "Fifty";
        if(n==6) return "Sixty";
        if(n==7) return "Seventy";
        if(n==8) return "Eighty";
        if(n==9) return "Ninety";
        return "";
    }
    public String int2tens(int n)
    {
        if(n==0) return "Ten";
        if(n==1) return "Eleven";
        if(n==2) return "Twelve";
        if(n==3) return "Thirteen";
        if(n==4) return "Fourteen";
        if(n==5) return "Fifteen";
        if(n==6) return "Sixteen";
        if(n==7) return "Seventeen";
        if(n==8) return "Eighteen";
        if(n==9) return "Nineteen";
        return "";
    }
}