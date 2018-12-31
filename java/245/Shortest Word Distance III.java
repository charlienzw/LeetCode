class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ipre = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].equals(word1) || words[i].equals(word2))
            {
                if(ipre == -1)
                {
                    ipre = i;
                }
                else
                {
                    if(word1.equals(word2))
                    {
                        res = Math.min(res, i - ipre);   
                        ipre = i;
                    }
                    else
                    {
                        if(!words[i].equals(words[ipre]))
                        {
                            res = Math.min(res, i - ipre);   
                            ipre = i;  
                        }
                        else
                        {
                            ipre = i;
                        }
                    }
                }
            }
        }
        return res;
    }
}