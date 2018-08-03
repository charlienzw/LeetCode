class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        long i=1;
        List<Integer> l=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        int tmp;
        while(x/i>0)
        {
            tmp=(int)(((long)x)/i%10);
            l.add(tmp);
            s.push(tmp);
            i=i*10;
        }
        int j=0;
        while(s.size()>0)
        {
            if(l.get(j)!=s.pop())
                return false;
            j++;
        }
        return true;
    }
}