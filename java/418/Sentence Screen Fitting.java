/*
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]   
curRow = 0
round = 0
i = 0
    curCol = 1 < cols
i = 1
    curCol = 5 < cols
i = 2
    curCol = 7 > cols
        curCol = 1
        curRow = 1
        if (curRow == rows)
            return round
    round = 1
    
["f","p","a"]
8
7

f-p-a-f
p-a-f-p
a-f-p-a
f-p-a-f
p-a-f-p
a-f-p-a
f-p-a-f
p-a-f-p

f-p-a-f-p-a-
        
*/

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 1) {
            if (sentence[0].length() > cols) return 0;
            else return rows * ((cols - sentence[0].length()) / (sentence[0].length() + 1) + 1);
        }
        int i = 1, curCol = sentence[0].length(), curRow = 0, round = 0;
        while (true) {
            curCol += (1 + sentence[i].length());
            
            if (curCol > cols) {
                curCol = sentence[i].length();
                curRow++;
                if (curRow == rows) {
                    return round;
                }
            }
            
            if (i == sentence.length - 1) {
                round++;
                i = 0;
            } else {
                i++;
            }
        }
    }
}