/* 
max(max(consecutive zeros length) / 2, left most zeros length, right most zeros length)
[1,0,0,0,1,0,1]
leftOneIndex = 0
rightOneIndex = 6
i = 0
i = 1
    zeroStart = 1
i = 2
i = 3
i = 4
    maxZeroLen = 2
    zeroStart = -1
i = 5
    zeroStart = 5
i = 6
    maxZeroLen = 1
    zeroStart = -1
    
[1,0,0,1]
leftOneIndex = 0
rightOneIndex = 3
i = 0
i = 1
    zeroStart = 1
i = 2
i = 3
    maxZeroStart = 1
    zeroStart = -1
*/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int leftOneIndex = 0;
        while(seats[leftOneIndex] != 1) {
            leftOneIndex++;
        }
        int rightOneIndex = seats.length - 1;
        while(seats[rightOneIndex] != 1) {
            rightOneIndex--;
        }
        int zeroStart = -1;
        int maxZeroLen = 0;
        for(int i = leftOneIndex; i <= rightOneIndex; i++) {
            if(seats[i] == 0) {
                if(zeroStart == -1) zeroStart = i;
            } else {
                if(zeroStart != -1) {
                    maxZeroLen = Math.max(maxZeroLen, (i - zeroStart - 1) / 2 + 1);
                    zeroStart = -1;
                }
            }
        }
        return Math.max(maxZeroLen ,Math.max(leftOneIndex, seats.length - 1 - rightOneIndex));
    }
}