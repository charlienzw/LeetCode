/*
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
input: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
inputarray: ["dir", "\tsubdir1", "\t\tfile1.ext", "\t\tsubsubdir1", "\tsubdir2", "\t\tsubsubdir2", "\t\t\tfile2.ext"]
res = 0
stack: 0
s = "dir":
    level = 0
    stack: 0, 4
s = "\tsubdir1":
    level = 1
    stack: 0, 4, 12
s = "\t\tfile1.ext":
    level = 2
    stack: 0, 4, 12, 21
    res = 20
s = "\t\tsubsubdir1":
    level = 2
    stack: 0, 4, 12, 23
s = "\tsubdir2":
    level = 1
    stack: 0, 4, 12
s = "\t\tsubsubdir2":
    level = 2
    stack: 0, 4, 12, 23
s = "\t\t\tfile2.ext":
    level = 3
    stack: 0, 4, 12, 23, 33
    res = 32
Time: O(n)
Space: O(n)
*/
class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        String[] inputarray = input.split("\n");
        for(String s : inputarray)
        {
            int level = s.lastIndexOf("\t") + 1;
            while(level + 1 < stack.size())
            {
                stack.pop();
            }
            stack.push(stack.peek() + s.length() - level + 1);
            if(s.contains(".")) res = Math.max(res, stack.peek() - 1);
        }
        return res;  
    }
}