class Solution {
    public String intToRoman(int num) {
        String res="";
        for(int i=0;i<num/1000;i++)
        {
            res=res.concat("M");
        }
        
        if(num%1000/100==9)
        {
            res=res.concat("CM");
            if(num%100/10==9)
            {
                res=res.concat("XC");
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }
            }
            else if(num%100/10==4)
            {
                res=res.concat("XL");
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }
            }
            else
            {
                for(int i=0;i<num%100/50;i++) 
                {
                    res=res.concat("L");
                }
                for(int i=0;i<num%50/10;i++) 
                {
                    res=res.concat("X");
                }                
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }                
            }
        }
        else if(num%1000/100==4)
        {
            res=res.concat("CD");
            if(num%100/10==9)
            {
                res=res.concat("XC");
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }
            }
            else if(num%100/10==4)
            {
                res=res.concat("XL");
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }
            }
            else
            {
                for(int i=0;i<num%100/50;i++) 
                {
                    res=res.concat("L");
                }
                for(int i=0;i<num%50/10;i++) 
                {
                    res=res.concat("X");
                }                
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }                
            }
        }
        else
        {
            for(int i=0;i<num%1000/500;i++)
            {
                res=res.concat("D");
            }
            for(int i=0;i<num%500/100;i++)
            {
                res=res.concat("C");
            }
            if(num%100/10==9)
            {
                res=res.concat("XC");
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }
            }
            else if(num%100/10==4)
            {
                res=res.concat("XL");
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }
            }
            else
            {
                for(int i=0;i<num%100/50;i++) 
                {
                    res=res.concat("L");
                }
                for(int i=0;i<num%50/10;i++) 
                {
                    res=res.concat("X");
                }                
                if(num%10==9)
                {
                    res=res.concat("IX");
                }
                else if(num%10==4)
                {
                    res=res.concat("IV");
                }
                else
                {
                    for(int i=0;i<num%10/5;i++)
                    {
                        res=res.concat("V");
                    }
                    for(int i=0;i<num%5;i++)
                    {
                        res=res.concat("I");
                    }
                }                
            }            
        }
        return res;
    }
}