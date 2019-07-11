//time: O(nlogk)
//space: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(); 
        q.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            q.add(nums[i]); //log(k)
            if(q.size() > k) {
                q.poll(); //log(k)
            }
        }
        return q.peek();
    }
}

//time: average O(n)
//space: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Random rnd = new Random();
        int temp;
        for(int i = 0; i < nums.length; i++) {
            int j = nums.length - 1 - rnd.nextInt(nums.length - i);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int index = quickselect(nums,0,nums.length-1,k);
        return nums[index];
    }
    public int quickselect(int[] nums, int low, int high, int k) {
        int x = nums[high];
        int i = low - 1;
        int temp;
        for(int j = low; j < high; j++) {
            if(nums[j] <= x) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;
        int m = high - i;
        if(m == k) return i + 1;
        else if(m > k) return quickselect(nums, i + 2, high, k);
        else return quickselect(nums, low, i, k - m);
    }
}

// 1. Split into n/5 groups O(n)
// 2. Get n/5 medians O(n)
// 3. Get median of medians T(n/5)
// 4. Use median to partition O(n)
// 5. compare m and k to recursively select T(7n/10+6)
// Master's method O(n)
// Time: O(n)
// Space: O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = quickselect(nums, 0, nums.length - 1, k);
        return nums[index];
    }
    public int quickselect(int[] nums, int low, int high, int k)
    {
        // Find the index of median
        int median = getmedian(nums, low, high);
        int mediani = 0;
        for(int i = low; i <= high; i++)
        {
            if(nums[i] == median)
            {
                mediani = i;
            }
        }
        
        swap(nums, mediani, high);

        int pivot = partition(nums, low, high);
        
        int m = high - pivot;
        if(m == k) return pivot + 1;
        else if(m > k) return quickselect(nums, pivot + 2, high, k);
        else return quickselect(nums, low, pivot, k - m);
    }
    
    private int partition(int[] nums, int low, int high) {
        int x = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int getmedian(int[] nums, int low, int high)
    {
        if (low == high) return nums[low];
        int[] medianarr = new int[(high - low + 1) / 5 + ((high - low + 1) % 5 != 0 ? 1 : 0)];
        List<Integer> grouplist = new ArrayList<>();
        int j = 0;
        for (int i = low; i <= high; i++) {
            if (grouplist.size() == 5) {
                Collections.sort(grouplist);
                medianarr[j] = grouplist.get(grouplist.size() / 2);
                j++;
                grouplist = new ArrayList<>();
                grouplist.add(nums[i]);
            } else {
                grouplist.add(nums[i]);
            }
        }
        Collections.sort(grouplist);
        medianarr[j] = grouplist.get(grouplist.size() / 2);
        return medianarr[quickselect(medianarr, 0, medianarr.length - 1, medianarr.length / 2 + 1)];
    }
}