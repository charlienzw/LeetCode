/*
T = [73, 74, 75, 71, 69, 72, 76, 73]
s: 73
i = 6
    T[i] = 76
    res[i] = 0
    s: 76
i = 5:
    T[i] = 72
    res[i] = 6 - 5 = 1
    s: 76, 72
i = 4:
    T[i] = 69
    res[i] = 5 - 4 = 1
    s: 76, 72, 69
i = 3:
    T[i] = 71
    res[i] = 5 - 3 = 2
    s: 76, 72, 71
i = 2:
    T[i] = 75
    res[i] = 6 - 2 = 4
    s: 76, 75
i = 1:
    T[i] = 74
    res[i] = 2 - 1 = 1
    s: 76, 75, 74
i = 0:
    T[i] = 73
    res[i] = 1 - 0 = 1
    s: 76, 75, 74, 73

Time: O(n)
Space: O(W), W is the number of warming points
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return null;
        int[] res = new int[T.length];
        Deque<Integer> s = new ArrayDeque<>();
        s.push(T.length - 1);
        int temp;
        for(int i = res.length - 2; i >= 0; i--)
        {
            while(s.size() > 0)
            {
                if(T[i] < T[s.peek()])
                {
                    res[i] = s.peek() - i;
                    break;
                }
                s.pop();
            }
            s.push(i);
        }
        return res;     
    }
}