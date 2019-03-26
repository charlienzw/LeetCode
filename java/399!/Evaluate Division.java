class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> nodePairs = new HashMap<>();
        Map<String, List<Double>> valuePairs = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            if(!nodePairs.containsKey(equations[i][0])) {
                nodePairs.put(equations[i][0], new ArrayList<>());
                valuePairs.put(equations[i][0], new ArrayList<>());
            }
            if(!nodePairs.containsKey(equations[i][1])) {
                nodePairs.put(equations[i][1], new ArrayList<>());
                valuePairs.put(equations[i][1], new ArrayList<>());
            }
            nodePairs.get(equations[i][0]).add(equations[i][1]);
            nodePairs.get(equations[i][1]).add(equations[i][0]);
            valuePairs.get(equations[i][0]).add(values[i]);
            valuePairs.get(equations[i][1]).add(1 / values[i]);    
        }
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            res[i] = helper(queries[i][0], queries[i][1], nodePairs, valuePairs, new HashSet<>(), 1.0);
            if(res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    
    public double helper(String s, String t, Map<String, List<String>> nodePairs, Map<String, List<Double>> valuePairs, Set<String> set, Double value) {
        if(set.contains(s)) return 0.0;
        if(!nodePairs.containsKey(s)) return 0.0;
        if(s.equals(t)) return value;
        set.add(s);
        List<String> nodeList = nodePairs.get(s);
        List<Double> valueList = valuePairs.get(s);
        double val = 0.0;
        for(int i = 0; i < nodeList.size(); i++) {
            val = helper(nodeList.get(i), t, nodePairs, valuePairs, set, value * valueList.get(i));
            if(val != 0.0) {
                break;
            }
        }
        set.remove(s);
        return val;
        
    }
}