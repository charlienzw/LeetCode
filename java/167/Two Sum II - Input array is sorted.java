class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        int[] tmp;
        int k;
        for(int i=0;i<numbers.length;i++)
        {
            tmp=new int[numbers.length-i-1];
            k=0;
            for(int l=i+1;l<numbers.length;l++)
            {
                tmp[k]=numbers[l];
                k=k+1;
            }
            int j=BS(tmp,target-numbers[i]);
            if(j!=-1)
            {
                res[0]=i+1;
                res[1]=j+i+2;
            }
        }
        return res;
    }
    
    public int BS(int[] numbers,int key)
    {
        int low=0;
        int high=numbers.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(key<numbers[mid]) high=mid-1;
            else if(key>numbers[mid]) low=mid+1;
            else return mid;
        }
        return -1;
    }
}