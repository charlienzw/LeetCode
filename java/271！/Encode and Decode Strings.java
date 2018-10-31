// Time: O(n)
// Space: O(1)
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++)
        {
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if(s == "") return res;
        int i = 0;
        int j;
        while(i < s.length())
        {
            j = s.indexOf('#', i);
            res.add(s.substring(j + 1, j + 1 + Integer.valueOf(s.substring(i, j))));
            i = j + 1 + Integer.valueOf(s.substring(i, j));
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));