/*
    > median
        put it to the current leftmost odd position
    < median
        put it to the current rightmost even position
    == median
        not move
        
*/
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        int median = kthSmallestNumber(nums, (n + 1) / 2);
        
        int left = 0, cur = 0, right = n - 1;
        while (cur <= right) {
            if (nums[getPos(cur, n)] > median) {
                swap(nums, getPos(left, n), getPos(cur, n));
                left++;
                cur++;
            } else if (nums[getPos(cur, n)] < median) {
                swap(nums, getPos(cur, n), getPos(right, n));
                right--;
            } else {
                cur++;
            }
        }
    }
    
    private int getPos(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }
        
        int low = 0, high = nums.length - 1;
        k--;
        while (low < high) {
            int pivot = partition(nums, low, high);
            if (pivot < k) {
                low = pivot + 1;
            } else if (pivot > k) {
                high = pivot - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int low, int high) {
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (nums[j] < nums[low]) swap(nums, ++i, j);
        }
        swap(nums, low, i);
        return i;
    }
    
}