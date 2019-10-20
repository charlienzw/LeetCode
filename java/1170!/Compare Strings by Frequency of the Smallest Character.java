class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] fWords = new int[words.length];
        for (int j = 0; j < fWords.length; j++) {
            fWords[j] = f(words[j]);
        }
        Arrays.sort(fWords);
        for (int i = 0; i < res.length; i++) {
            res[i] = binarySearch(fWords, f(queries[i]));
        }
        return res;
    }
    
    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) low = mid + 1;
            else high = mid;
        }
        if (x < arr[low]) return arr.length - low;
        return 0;
    }
    
    private int f(String s) {
        char curChar = 'z';
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curChar) cnt++;
            else if (s.charAt(i) < curChar) {
                curChar = s.charAt(i);
                cnt = 1;
            }
        }
        return cnt;
    }
}