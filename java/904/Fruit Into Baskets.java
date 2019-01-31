/*
Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
num1 = null, num2 = null, num2first = -1;
i = 0
    num1 = null
    num2 = 3
    res = 0
    tempres = 1
    num2first = 0
i = 1
    num1 = null
    num2 = 3
    res = 0
    tempres = 2    
    num2first = 0
i = 2
    num1 = null
    num2 = 3
    res = 0
    tempres = 3
    num2first = 0
i = 3
    num1 = 3
    num2 = 1
    res = 0
    tempres = 4
    num2first = 3
i = 4
    num1 = 1
    num2 = 2
    res = 4
    tempres = 2
    num2first = 4
i = 5
    num1 = 2
    num2 = 1
    res = 4
    tempres = 3
    num2first = 5
i = 6
    num1 = 2
    num2 = 1
    res = 4
    tempres = 4
    num2first = 5
i = 7
    num1 = 1
    num2 = 2
    res = 4
    tempres = 5
    num2first = 7
i = 8
    num1 = 2
    num2 = 3
    res = 5
    tempres = 2
    num2first = 8
i = 9
    num1 = 2
    num2 = 3
    res = 5
    tempres = 3
    num2first = 8
i = 10
    num1 = 3
    num2 = 4
    res = 5
    tempres = 3
    num2first = 10

*/
class Solution {
    public int totalFruit(int[] tree) {
        Integer num1 = null, num2 = null;
        int num2first = -1;
        int res = 0;
        int tempres = 0;
        int temp;
        for(int i = 0; i < tree.length; i++){
            if(num2 == null || num1 == null && num2 != tree[i]){
                num1 = num2;
                num2 = tree[i];
                num2first = i;
                tempres++;
            }
            else if(num2 != tree[i] && num1 != tree[i]){
                num1 = num2;
                num2 = tree[i];
                res = Math.max(res, tempres);
                tempres = i - num2first + 1;
                num2first = i;
            }
            else{
                if(num2 != tree[i]){
                    temp = num1;
                    num1 = num2;
                    num2 = temp;
                    num2first = i;
                }
                tempres++;
            }
        }
        res = Math.max(res, tempres);
        return res;
    }
}