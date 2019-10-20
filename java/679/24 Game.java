class Solution {
    boolean res = false;
    public boolean judgePoint24(int[] nums) {
        List<Double> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add((double)nums[i]);
        }
        helper(numList);
        return res;
    }
    
    private void helper(List<Double> curList) {
        if(res) return;
        if (curList.size() == 1) {
            if (Math.abs(curList.get(0) - 24) < 1e-6) {
                res = true;
            }
            return;
        }
        
        for (int i = 0; i < curList.size(); i++) {
            for (int j = i + 1; j < curList.size(); j++) {
                Double a = curList.get(i);
                Double b = curList.get(j);
                curList.remove(j);
                curList.remove(i);
                
                curList.add(a + b);
                helper(curList);
                curList.remove(curList.size() - 1);
                
                curList.add(a - b);
                helper(curList);
                curList.remove(curList.size() - 1);
                
                curList.add(b - a);
                helper(curList);
                curList.remove(curList.size() - 1);
                
                curList.add(a * b);
                helper(curList);
                curList.remove(curList.size() - 1);
                
                if (b != 0) {
                    curList.add(a / b);
                    helper(curList);
                    curList.remove(curList.size() - 1);                    
                }

                if (a != 0) {
                    curList.add(b / a);
                    helper(curList);
                    curList.remove(curList.size() - 1);                    
                }

                curList.add(i, a);
                curList.add(j, b);
            }
        }
        
    }
}