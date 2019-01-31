class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            StringBuilder sb = new StringBuilder();
            int pre = 0;
            boolean lock = false;
            for(int j = 0; j < emails[i].length(); j++){
                if(!lock && emails[i].charAt(j) == '.'){
                    sb.append(emails[i].substring(pre, j));
                    pre = j + 1;
                }
                else if(!lock && emails[i].charAt(j) == '+'){
                    sb.append(emails[i].substring(pre, j));
                    lock = true;
                }
                else if(emails[i].charAt(j) == '@'){
                    pre = j;
                    break;
                }
            }
            sb.append(emails[i].substring(pre));
            set.add(sb.toString());
        }
        return set.size();
    }
}