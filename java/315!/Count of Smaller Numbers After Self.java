class Item {
    int value;
    int index;
    public Item(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Item[] items = new Item[nums.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(nums[i], i);
        }
        
        int[] count = new int[items.length];
        mergeSort(items, 0, items.length - 1, count);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }
    
    private void mergeSort(Item[] items, int low, int high, int[] count) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(items, low, mid, count);
        mergeSort(items, mid + 1, high, count);
        merge(items, low, mid, mid + 1, high, count);
    }
    
    private void merge(Item[] items, int low, int lowEnd, int high, int highEnd, int[] count) {
        Item[] sorted = new Item[highEnd - low + 1];
        int rightCount = 0;
        int k = 0, l = low, h = high;
        
        while (l <= lowEnd && h <= highEnd) {
            if (items[h].value < items[l].value) {
                rightCount++;
                sorted[k++] = items[h++];
            } else {
                count[items[l].index] += rightCount;
                sorted[k++] = items[l++];
            }
        }
        
        while (l <= lowEnd) {
            count[items[l].index] += rightCount;
            sorted[k++] = items[l++];
        }
        
        while (h <= highEnd) {
            sorted[k++] = items[h++];
        }
        
        for (int j = 0; j < sorted.length; j++) {
            items[low + j] = sorted[j];
        }
    }
}