class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        int sign = 1;
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) sign = 0;
        long lnumerator = (long)Math.abs((long)numerator);
        long ldenominator = (long)Math.abs((long)denominator);
        
        StringBuilder sb = new StringBuilder();
        sb.append(lnumerator / ldenominator);
        if(lnumerator % ldenominator == 0) return sign == 1 ? sb.toString() : "-" + sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(lnumerator % ldenominator != 0)
        {
            lnumerator = lnumerator % ldenominator * 10;
            if(map.containsKey(lnumerator)) 
            {
                sb.insert(map.get(lnumerator), "(");
                sb.append(")");
                break;
            }
            else 
            {
                map.put(lnumerator, sb.length());    
                sb.append(lnumerator / ldenominator);
            }
        }
        return sign == 1 ? sb.toString() : "-" + sb.toString();
    }
}