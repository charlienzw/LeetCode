// Time: O(nlogn) Space: O(1)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i;
        for(i=1;i<=citations.length;i++)
        {
            if (citations[citations.length-i]<i)
            {
                break;
            }
        }
        return i-1;
    }
}



// Time: O(n) Space: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int[] helper=new int[citations.length+1];
        for(int i=0;i<citations.length;i++)
        {
            helper[citations[i]<=citations.length?citations[i]:citations.length]++;
        }
        int sum=0;
        for(int i=citations.length;i>0;i--)
        {
            sum=sum+helper[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }
}