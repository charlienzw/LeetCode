class KthLargest {
    class TreeNode
    {
        int val;
        int cnt;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, int cnt)
        {
            this.val = val;
            this.cnt = cnt;
        }
    }
    TreeNode root;
    int kcnt;
    public KthLargest(int k, int[] nums) {
        createBST(nums);
        kcnt = k;
    }
    
    public int add(int val) {
        insert(val);
        return selectk(root, kcnt);
    }
    
    public int selectk(TreeNode cur, int k)
    {
        int m = cur.right == null ? 0 : cur.right.cnt;
        if(m == k - 1)
        {
            return cur.val;
        }
        else if(m < k - 1)
        {
            return selectk(cur.left, k - m - 1);
        }
        else
        {
            return selectk(cur.right, k);
        }
    }
    
    public void createBST(int[] nums)
    {
        if(nums.length == 0)
        {
            root = null;
            return;
        }
        shuffleArray(nums);
        for(int i = 0; i < nums.length; i++)
        {
            insert(nums[i]);
        }
    }
    

    public void insert(int val) {
        if(root == null)
        {
            root = new TreeNode(val, 1);
            return;
        }
        TreeNode cur = root;
        while(true)
        {
            if(val < cur.val)
            {
                if(cur.left == null)
                {
                    cur.cnt++;
                    cur.left = new TreeNode(val, 1);
                    return;
                }
                else
                {
                    cur.cnt++;
                    cur = cur.left;
                }
            }
            else
            {
                if(cur.right == null) 
                {
                    cur.cnt++;
                    cur.right = new TreeNode(val, 1);
                    return;
                }
                else
                {
                    cur.cnt++;
                    cur = cur.right;
                    
                }
            }
        }
    }
    
    public void shuffleArray(int[] arr)
    {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          int a = arr[index];
          arr[index] = arr[i];
          arr[i] = a;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */