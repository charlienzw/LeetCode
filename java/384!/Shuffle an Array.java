// Prove: in ith in the loop, the probability of permutation[i-1] appears in A[0...i-1] is (n-i+1)!/n!
// 1. i=0 empty permutation in A[0..-1] is 1
// 2. assume i-1th, then prove ith
//    (1/(n-i+1))*((n-i+1)!/n!)=(n-i)!/n!
// So when i=n P=1/n!
// time:O(n)
// space:O(n)
class Solution {
    int[] arr;
    int[] origin;
    public Solution(int[] nums) {
        arr=nums;
        origin=nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr=origin;
        origin=origin.clone();
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rnd=new Random();
        int i,temp;
        for(int j=0;j<arr.length;j++)
        {
            i=arr.length-rnd.nextInt(arr.length-j)-1;
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */