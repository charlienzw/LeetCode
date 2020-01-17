class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        int bottomLeftX = Integer.MAX_VALUE, bottomLeftY = Integer.MAX_VALUE, topRightX = Integer.MIN_VALUE, topRightY = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        int area = 0;
        for (int[] rect : rectangles) {
            bottomLeftX = Math.min(bottomLeftX, rect[0]);
            bottomLeftY = Math.min(bottomLeftY, rect[1]);
            topRightX = Math.max(topRightX, rect[2]);
            topRightY = Math.max(topRightY, rect[3]);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
            
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        if (!set.contains(bottomLeftX + " " + bottomLeftY) || !set.contains(bottomLeftX + " " + topRightY) || !set.contains(topRightX + " " + topRightY) || !set.contains(topRightX + " " + bottomLeftY) || set.size() != 4) return false;
        return area == (topRightX - bottomLeftX) * (topRightY - bottomLeftY);
    }
}