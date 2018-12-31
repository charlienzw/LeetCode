/*
[1, 3, 2] k = 1
day: [1, 3, 2]
slow = 0, fast = 2
    2 < 3
        flag = true
            i = 1
        res = 
*/
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] day = new int[flowers.length];
        for(int i = 0; i < flowers.length; i++)
        {
            day[flowers[i] - 1] = i + 1;
        }
        
        int slow = 0, fast = k + 1;
        int res = Integer.MAX_VALUE;
        boolean flag;
        while(fast < day.length)
        {
            flag = true;
            for(int i = slow + 1; i < fast; i++)
            {
                if(day[i] < day[slow] || day[i] < day[fast])
                {
                    slow = i;
                    fast = slow + k + 1;
                    flag = false;
                    break;
                }
            }
            if(flag) 
            {
                res = Math.min(res, Math.max(day[slow], day[fast]));
                slow = fast;
                fast = slow + k + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}