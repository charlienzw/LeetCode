class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int ni = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(ni < Math.pow(2,nums.length))
        {
            String S = Integer.toBinaryString(ni);
            List<Integer> resulti = new ArrayList<Integer>();
            for (int i = S.length() - 1; i >= 0; i--)
            {
                if (S.charAt(i) == '1')
                {
                    resulti.add(nums[S.length() - i - 1]);
                }
            }
            result.add(resulti);
            ni++;
        }    
        return result;
    }
}