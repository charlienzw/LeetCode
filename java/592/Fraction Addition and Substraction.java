/**
* Time: O(nlogx)
* n is the number of factors. x is the maximum value of denominators.
* Space: O(n)
*/

class Solution {
    public String fractionAddition(String expression) {
        if (expression == null || expression.length() == 0) return "";
        List<Character> signs = new ArrayList<>();
        if (expression.charAt(0) == '-') {
            signs.add('-');
        } else {
            signs.add('+');
        }
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                signs.add(expression.charAt(i));
            }
        }
        
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        
        // Use "\\" to escape "\" in Java
        // Use "\+" to escape "+" in regex
        String[] factors = expression.split("(\\+)|(-)");
        for (String factor : factors) {
            if (factor.length() > 0) {
                String[] terms = factor.split("/");
                numerators.add(Integer.valueOf(terms[0]));
                denominators.add(Integer.valueOf(terms[1]));
            }
        }
        
        int denominatorRes = 1;
        for (Integer denominator : denominators) {
            denominatorRes = lcm(denominatorRes, denominator);
        }
        
        int numeratorRes = 0;
        for (int i = 0; i < numerators.size(); i++) {
            if (signs.get(i) == '+') {
                numeratorRes += numerators.get(i) * (int)(denominatorRes / denominators.get(i));
            } else {
                numeratorRes -= numerators.get(i) * (int)(denominatorRes / denominators.get(i));
            }
        }
        
        if (numeratorRes == 0) {
            return "0/1";
        }
        
        int gcdRes = gcd(numeratorRes, denominatorRes);
        numeratorRes /= gcdRes;
        denominatorRes /= gcdRes;
        
        String signRes = "";
        if (numeratorRes < 0 && denominatorRes > 0 || numeratorRes > 0 && denominatorRes < 0) {
            signRes = "-";
        }
        
        return signRes + Math.abs(numeratorRes) + "/" + Math.abs(denominatorRes);
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}