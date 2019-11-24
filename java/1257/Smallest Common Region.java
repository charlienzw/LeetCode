class Solution {
    String res = "";
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> region : regions) {
            Set<String> set = new HashSet<>();
            for (int i = 1; i < region.size(); i++) {
                set.add(region.get(i));
            }
            map.put(region.get(0), set);
        }
        
        for (String s : map.keySet()) {
            helper(s, map, region1, region2);
        }
        return res;
    }
    
    private boolean helper(String s, Map<String, Set<String>> map, String region1, String region2) {
        if (!res.isEmpty()) return false;

        boolean flag = s.equals(region1) || s.equals(region2);
        if (!map.containsKey(s)) {
            return flag;
        }
        
        Set<String> set = map.get(s);
        for (String ss : set) {
            if (helper(ss, map, region1, region2)) {
                if (!flag) flag = true;
                else {
                    res = s;
                    return false;
                }
            }
        }
        return flag;
    }
}