class Item{
    public String str;
    public int index;
    public Item(String s,int i){
        str=s;
        index=i;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int index=wordList.indexOf(endWord);
        if(index==-1) return 0;
        Queue<Item> q=new LinkedList<>();
        q.add(new Item(endWord,1));
        wordList.remove(endWord);
        int qsize=1;
        Item temp;
        while(q.size()>0)
        {
            qsize=q.size();
            for(int j=0;j<qsize;j++)
            {
                temp=q.poll();
                if(dis(temp.str,beginWord)==1)
                {
                    return temp.index+1;
                }
                for(int i=0;i<wordList.size();i++)
                {
                    if(dis(wordList.get(i),temp.str)==1)
                    {
                        q.add(new Item(wordList.get(i),temp.index+1));
                        wordList.remove(wordList.get(i));
                    }
                }
            }
        }
        return 0;
    }
    public int dis(String word1,String word2)
    {
        int s=0;
        for(int i=0;i<word1.length();i++)
        {
            if(word1.charAt(i)!=word2.charAt(i))
                s++;
        }
        return s;
    }
}