class Solution {
    int[] pre;
    public Solution(int[] w) {
        pre = new int[w.length];
        for(int i = 0; i < w.length; i++)
        {
            pre[i] = i == 0 ? w[i] : pre[i - 1] + w[i];
        }        
    }
    
    public int pickIndex() {
        int x = (int)(Math.random() * pre[pre.length - 1]);
        int low = 0, high = pre.length - 1;
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if(pre[mid] > x)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */