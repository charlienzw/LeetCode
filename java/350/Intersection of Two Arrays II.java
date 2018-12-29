class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultlist = new ArrayList<>();
        Map<Integer, Integer> h1 = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(!h1.containsKey(nums1[i]))
            {
                h1.put(nums1[i], 1);
            }
            else
            {
                h1.put(nums1[i], h1.get(nums1[i]) + 1);
            }
        }
        for(int i = 0; i < nums2.length; i++)
        {
            if(h1.containsKey(nums2[i]) && h1.get(nums2[i]) > 1)
            {
                resultlist.add(nums2[i]);
                h1.put(nums2[i], h1.get(nums2[i]) - 1);
            }
            else if(h1.containsKey(nums2[i]))
            {
                resultlist.add(nums2[i]);
                h1.remove(nums2[i]);
            }
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