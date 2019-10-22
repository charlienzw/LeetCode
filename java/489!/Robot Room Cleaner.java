/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    Set<List<Integer>> visited = new HashSet<>();
    public void cleanRoom(Robot robot) {
        helper(robot, 0, 0, new Integer[] {1, 0});
    }
    
    private void helper(Robot robot, int row, int column, Integer[] dir) {
        robot.clean();
        visited.add(Arrays.asList(new Integer[] {row, column}));
        
        Integer[] curDir = new Integer[] {dir[0], dir[1]};
        while (true) {
            if (!visited.contains(Arrays.asList(new Integer[] {row + curDir[0], column + curDir[1]})) && robot.move()) {
                helper(robot, row + curDir[0], column + curDir[1], curDir);
                // back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            turnRight(curDir);
            if (curDir[0] == dir[0] && curDir[1] == dir[1]) break;
        }
    }
    
    private void turnRight(Integer[] dir) {
        int new0, new1;
        if (dir[0] == 1 || dir[0] == -1) new0 = 0;
        else new0 = -dir[1];
        if (dir[1] == 1 || dir[1] == -1) new1 = 0;
        else new1 = dir[0];  
        dir[0] = new0;
        dir[1] = new1;
    }
}