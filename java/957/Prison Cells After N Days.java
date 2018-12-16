/*
[0, 1, 1]
[0, 0, 1]

[0, 1, 0, 1]
[0, 1, 1, 1]
[0, 0, 1, 1]
[0, 0, 0, 1]
[0, 1, 0, 1]

Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
Day 8: [0, 0, 0, 0, 0, 1, 1, 0]
Day 9: [0, 1, 1, 1, 0, 0, 0, 0]
Day 10: [0, 0, 1, 0, 0, 1, 1, 0]
Day 11: [0, 0, 1, 0, 0, 0, 0, 0]
Day 12: [0, 0, 1, 0, 1, 1, 1, 0]
Day 13: [0, 0, 1, 1, 0, 1, 0, 0]
Day 14: [0, 0, 0, 0, 1, 1, 0, 0]
Day 15: [0, 1, 1, 0, 0, 0, 0, 0]

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
10010010 0
00010010 1
01010010 2
01110010 3
00100010 4
00101010 5
00111110 6 
00011100 7 
01001000 8
01001010 9
01001110 10
01000100 11
01010100 12
01111100 13
00111000 14
00010010
cyclestart = 1
N = 15: cyclelist.get(1) = cyclelist.get(cyclestart + (N - cyclestart) % (cyclelist.size() - cyclestart))


*/
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells.length == 0 || N == 0) return cells;
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> cyclelist = new ArrayList<>();
        int[] temp = cells.clone();
        int cyclestart = 0;
        int i;
        for(i = 0; i < N; i++)
        {
            if(!map.containsKey(arr2int(temp))) map.put(arr2int(temp), i);
            else
            {
                cyclestart = map.get(arr2int(temp));
                break;
            }
            cyclelist.add(temp);
            cells[0] = cells[cells.length - 1] = 0;
            for(int j = 1; j < cells.length - 1; j++)
            {
                cells[j] = temp[j - 1] ^ temp[j + 1] ^ 1;
            }
            temp = cells.clone();
        }
        if(i < N) return cyclelist.get(cyclestart + (N - cyclestart) % (cyclelist.size() - cyclestart));
        else
        {
            return temp;
        }
    }
    public int arr2int(int[] arr)
    {
        int res = 0;
        for(int i = 0; i < arr.length; i++)
        {
            res += Math.pow(2, arr.length - 1 - i) * arr[i];
        }
        return res;
    }
}