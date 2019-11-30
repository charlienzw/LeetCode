/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1]) return 0;
        if (bottomLeft[0] == topRight[0] && bottomLeft[1] == topRight[1]) return sea.hasShips(topRight, bottomLeft) ? 1 : 0;
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (bottomLeft[0] == topRight[0] && bottomLeft[1] + 1 == topRight[1] || bottomLeft[1] == topRight[1] && bottomLeft[0] + 1 == topRight[0]) {
            return countShips(sea, bottomLeft, bottomLeft) + countShips(sea, topRight, topRight);
        }
        int res = 0;
        int[] mid = new int[] { bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2, bottomLeft[1] + (topRight[1] - bottomLeft[1]) / 2 };
        res += countShips(sea, new int[] { topRight[0], mid[1] }, new int[] { mid[0], bottomLeft[1] });
        res += countShips(sea, new int[] { mid[0] - 1, mid[1] }, bottomLeft);
        res += countShips(sea, topRight, new int[] { mid[0], mid[1] + 1 });
        res += countShips(sea, new int[] { mid[0] - 1, topRight[1] }, new int[] { bottomLeft[0], mid[1] + 1 });
        return res;
    }
}