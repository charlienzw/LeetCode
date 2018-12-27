class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Find the pivot
        int low = 0, high = arr.length - 1;
        int pivot = 0;
        while(low + 1 < high)
        {
            int mid = low + (high - low) / 2;
            if(arr[mid] == x)
            {
                pivot = mid;
                break;
            }
            else if(arr[mid] > x) high = mid;
            else low = mid;
        }
        
        //If arr[pivot] == x, the pivot is the final pivot
        //Otherwise, we should return the closer one of low and right as the pivot
        if(arr[pivot] != x)
        {
            if(Math.abs(x - arr[low]) <= Math.abs(x - arr[high]))
            {
                pivot = low;
            }
            else
            {
                pivot = high;
            }
        }
        
        //Two pointer find the two limit
        //Left and right are both not included
        int left = pivot - 1, right = pivot + 1;
        for(int i = 1; i < k; i++)
        {
            if(right >= arr.length || left >= 0 && x - arr[left] <= arr[right] - x)
            {
                left--;
            }
            else
            {
                right++;
            }
        }
        
        //Return the result
        List<Integer> res = new ArrayList<>();
        for(int i = left + 1; i < right; i++)
        {
            res.add(arr[i]);
        }
        return res;
    }
}