/*
4x + 2y = t, x + y = c
x = (t - 2c) / 2
y = (4c - t) / 2
*/
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices < 2 * cheeseSlices || (tomatoSlices - 2 * cheeseSlices) % 2 != 0) return new ArrayList<>();
        if (4 * cheeseSlices < tomatoSlices || (4 * cheeseSlices - tomatoSlices) % 2 != 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add((tomatoSlices - 2 * cheeseSlices) / 2);
        res.add((4 * cheeseSlices - tomatoSlices) / 2);
        return res;
    }
}