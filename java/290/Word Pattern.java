class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] strArr = str.split(" ");
        if(strArr.length != pattern.length()) return false;
        for(int i = 0; i < strArr.length; i++){
            if(map1.containsKey(pattern.charAt(i))){
                if(!map1.get(pattern.charAt(i)).equals(strArr[i])){
                    return false;
                }
            }
            else if(map2.containsKey(strArr[i])){
                if(map2.get(strArr[i]) != pattern.charAt(i)){
                    return false;
                }
            }
            else{
                map1.put(pattern.charAt(i), strArr[i]);
                map2.put(strArr[i], pattern.charAt(i));
            } 
        }
        return true;
    }
}