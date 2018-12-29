class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> resultlist = new HashSet<Integer>();
        HashSet<Integer> h1 = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            h1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++)
        {
            if(h1.contains(nums2[i])) resultlist.add(nums2[i]);
        }
        int[] result = new int[resultlist.size()];
        int index = 0;
        for (Integer i : resultlist) 
        {
            result[index] = i;
            index = index + 1;
        }
        return result;
    }     
}