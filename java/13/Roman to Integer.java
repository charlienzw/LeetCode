class Solution {
    public int romanToInt(String s) {
        int num=0;
        for (int i=0;i<s.length();i++)
        {
            if (i<s.length()-1)
            {
                if (C2N2(s.charAt(i),s.charAt(i+1))>0)
                {
                    num=num+C2N2(s.charAt(i),s.charAt(i+1));
                    i++;
                }
                else
                {
                    num=num+C2N(s.charAt(i));
                }
            }
            else
                num=num+C2N(s.charAt(i));     
        }
        return num;
    }
    public int C2N(char c){
        if (c=='I') return 1;
        if (c=='V') return 5;
        if (c=='X') return 10;
        if (c=='L') return 50;
        if (c=='C') return 100;
        if (c=='D') return 500;
        if (c=='M') return 1000;
        else return -1;
    }
    public int C2N2(char c1, char c2){
        if (c1=='I'&&c2=='V') return 4;
        if (c1=='I'&&c2=='X') return 9;
        if (c1=='X'&&c2=='L') return 40;
        if (c1=='X'&&c2=='C') return 90;
        if (c1=='C'&&c2=='D') return 400;
        if (c1=='C'&&c2=='M') return 900;
        return -1;
    }
}