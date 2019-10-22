// Merge Sort
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, mid + 1, high);
    }
    
    private void merge(int[] nums, int low, int lowEnd, int high, int highEnd) {
        int curL = low, curH = high;
        int[] sorted = new int[highEnd - low + 1];
        int k = 0;
        while (curL <= lowEnd && curH <= highEnd) {
            if (nums[curL] < nums[curH]) {
                sorted[k++] = nums[curL++];
            } else {
                sorted[k++] = nums[curH++];
            }
        }
        while (curL <= lowEnd) {
            sorted[k++] = nums[curL++];
        }
        while (curH <= highEnd) {
            sorted[k++] = nums[curH++];
        }
        for (int i = 0; i < sorted.length; i++) {
            nums[low + i] = sorted[i];
        }
    }
}

// Quick Sort
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }
    
    private int partition(int[] nums, int low, int high) {
        int candidate = low + (int)(Math.random() * (high - low + 1));
        swap(nums, low, candidate);
        int index = low + 1;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < nums[low]) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, low, index - 1);
        return index - 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}

// Heap Sort
class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
    
    private void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i); //maxHeap
        }
        
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }
    
    private void heapify(int[] nums, int n, int i) {
        int left = i * 2 + 1, right = i * 2 + 2;
        int largest = i;
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}

// Bucket Sort
class Solution {
    public int[] sortArray(int[] nums) {
        bucketSort(nums);
        return nums;
    }
    
    private void bucketSort(int[] nums) {
        ArrayList<Integer>[] buckets = new ArrayList[1000];
        for (int i = 0; i < nums.length; i++) {
            if (buckets[(nums[i] + 50000) / 100] == null) buckets[(nums[i] + 50000) / 100] = new ArrayList<>();
            buckets[(nums[i] + 50000) / 100].add(nums[i]);
        }
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            Collections.sort(buckets[i]);
            for (Integer j : buckets[i]) {
                nums[k++] = j;
            }
        }
    }
    
}
