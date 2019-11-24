class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, String> map = new HashMap<>();
        for (List<String> synonym : synonyms) {
            map.put(synonym.get(0), synonym.get(1));
            map.put(synonym.get(1), synonym.get(0));
        }
        String[] splitText = text.split(" ");
        List<String> res = new ArrayList<>();
        helper(res, splitText, map, new StringBuilder(), 0);
        Collections.sort(res);
        return res;
    }
    
    private void helper(List<String> res, String[] splitText, Map<String, String> map, StringBuilder sb, int cur) {
        if (cur == splitText.length) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        
        Set<String> set = new HashSet<>();
        String curText = splitText[cur];
        set.add(curText);
        sb.append(curText + " ");
        helper(res, splitText, map, sb, cur + 1);
        sb.delete(sb.length() - curText.length() - 1, sb.length());
        while (map.containsKey(curText)) {
            curText = map.get(curText);
            if (set.contains(curText)) break;
            set.add(curText);
            sb.append(curText + " ");
            helper(res, splitText, map, sb, cur + 1);
            sb.delete(sb.length() - curText.length() - 1, sb.length());
        }
    }
}