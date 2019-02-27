class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }
        
        Map<String, Integer> countUnbanned = new HashMap<>();
        int start = -1;
        for(int i = 0; i < paragraph.length(); i++) {
            if(!Character.isLetter(paragraph.charAt(i))) {
                if(start == -1) continue;
                String lowerString = paragraph.substring(start, i).toLowerCase();
                if(!bannedSet.contains(lowerString)) {
                    countUnbanned.put(lowerString, countUnbanned.getOrDefault(lowerString, 0) + 1);
                }
                start = -1;
            }
            else {
                if(start == -1) start = i;
            }
        }
        
        if(start != -1) {
            String lowerString = paragraph.substring(start).toLowerCase();
            if(!bannedSet.contains(lowerString)) {
                countUnbanned.put(lowerString, countUnbanned.getOrDefault(lowerString, 0) + 1);
            }          
        }
        
        int maxCount = 0;
        String maxString = "";
        for(String key : countUnbanned.keySet()) {
            if(countUnbanned.get(key) > maxCount) {
                maxCount = countUnbanned.get(key);
                maxString = key;
            }
        }
        return maxString;
    }
}