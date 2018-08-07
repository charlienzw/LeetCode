class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        int n1,n2;
        for(int i=0;i<Math.max(s1.length,s2.length);i++)
        {
            if(i<s1.length)
            {
                n1=Integer.parseInt(s1[i]);
            }
            else
            {
                n1=0;
            }
            if(i<s2.length)
            {
                n2=Integer.parseInt(s2[i]);
            }
            else
            {
                n2=0;
            }
            if(n1<n2) return -1;
            if(n1>n2) return 1;
        }
        return 0;
    }
}