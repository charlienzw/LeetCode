class Solution {
    
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<>();
        helper(res, N, K, 0, 0, null);
        int[] resarr = new int[res.size()];
        int i = 0;
        for(int x : res)
        {
            resarr[i++] = x;
        }
        return resarr;
    }
    
    public void helper(List<Integer> res, int N, int K, int cur, int num, Integer lastdigit)
    {
        if(cur == N)
        {
            res.add(num);
            return;
        }
        for(int i = 0; i <= 9; i++)
        {
            if(cur == 0 && N != 1 && i == 0)
            {
                continue;
            }
            if(lastdigit != null && Math.abs(lastdigit - i) != K)
            {
                continue;
            }
            helper(res, N, K, cur + 1, num * 10 + i, i);
        }
    }
}