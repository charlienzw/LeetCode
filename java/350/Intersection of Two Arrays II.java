// O(n) time
// O(n) extra space
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultlist = new ArrayList<>();
        Map<Integer, Integer> h1 = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            h1.put(nums1[i], h1.getOrDefault(nums1[i], 0) + 1);
        }
        for(int i = 0; i < nums2.length; i++)
        {
            if(h1.containsKey(nums2[i]))
            {
                resultlist.add(nums2[i]);
                h1.put(nums2[i], h1.get(nums2[i]) - 1);
                if(h1.get(nums2[i]) == 0) h1.remove(nums2[i]);
            }
        }
        int[] result = new int[resultlist.size()];
        int index = 0;
        for (Integer i : resultlist) 
        {
            result[index++] = i;
        }
        return result;
    }     
}

// O(nlogn) time
// O(1) extra space
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        for(i = 0; i < res.size(); i++) {
            resArr[index++] = res.get(i);
        }
        return resArr;
    }
}