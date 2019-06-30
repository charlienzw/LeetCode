/*
    Get the label of the upper row in the path
        Which row should a label be?
            2 ^ i <= label < 2 ^ (i + 1)
            i = log2(label)
            
        Is current row left to right or right to left?
            row i (from 0)
                if i % 2 == 0
                    left to right
                else
                    right to left
        
        What is the start label of this row?
            startLabel = 2 ^ i
        
        How many nodes in the upper row?
            How many nodes in i-th row?
                2 ^ i
        
        The label of the upper row: startLabel - 1 - (label - startLabel) / 2 
                

*/
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = (int)(Math.log(label)/Math.log(2));
        while(label != 0) {
            res.addFirst(label);
            int startLabel = (int)Math.pow(2, i);
            i--;
            label = startLabel - 1 - (label - startLabel) / 2;
        }
        return res;
    }
}