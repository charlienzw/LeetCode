class Solution {
    class Trie{
        class TrieNode{
            TrieNode[] children = new TrieNode[2];
            int val = 0;
        }
        TrieNode root = new TrieNode();
        
        public void insert(int num)
        {
            TrieNode cur = root;
            for(int i = 31; i >= 0; i--)
            {
                int curbit = (num & (1 << i)) != 0 ? 1 : 0;
                if(cur.children[curbit] == null)
                {
                    cur.children[curbit] = new TrieNode();
                }
                cur = cur.children[curbit];
            }
            cur.val = num;
        }
        
        public int findXormax(int num)
        {
            TrieNode cur = root;
            for(int i = 31; i >= 0; i--)
            {
                int curbit = (num & (1 << i)) != 0 ? 1 : 0;
                if(cur.children[1 - curbit] != null)  // Try to find the different curbit to maximize the result
                {
                    cur = cur.children[1 - curbit];
                }
                else
                {
                    cur = cur.children[curbit];
                }
            }
            return num ^ cur.val;
        }
    }


    public int findMaximumXOR(int[] nums) {
        if(nums.length == 1) return 0;
        int res = Integer.MIN_VALUE;
        Trie t = new Trie();
        t.insert(nums[0]);
        for(int i = 1; i < nums.length; i++)
        {
            res = Math.max(res, t.findXormax(nums[i])); // The pair has no sequence so just compare the elements before current one
            t.insert(nums[i]);
        }
        return res;
    }
}