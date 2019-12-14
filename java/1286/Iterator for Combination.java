class CombinationIterator {
    int[] index;
    String characters;
    boolean next;
    public CombinationIterator(String characters, int combinationLength) {
        index = new int[combinationLength];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        this.characters = characters;
        next = true;
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            sb.append(characters.charAt(index[i]));
        }
        int toAddIndex = -1;
        for (int i = index.length - 1; i >= 0; i--) {
            if (index[i] < characters.length() - (index.length - i)) {
                toAddIndex = i;
                break;
            }
        }
        if (toAddIndex != -1) {
            index[toAddIndex]++;
            for (int i = toAddIndex + 1; i < index.length; i++) {
                index[i] = index[toAddIndex] + (i - toAddIndex);
            }
        }
        else next = false;
        return sb.toString();
    }
    
    public boolean hasNext() {
        return next;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */