class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] A=new int[n];
        for(int i=0;i<n;i++)
        {
            A[i]=triangle.get(n-1).get(i);
        }
        for(int i=triangle.size()-1;i>=1;i--)
        {
            for(int j=0;j<i;j++)
            {
                A[j]=triangle.get(i-1).get(j)+min(A[j],A[j+1]);
            }
        }
        return A[0];
    }
    
    public int min(int a,int b)
    {
        if(a>b)
            return b;
        else
            return a;
    }
}