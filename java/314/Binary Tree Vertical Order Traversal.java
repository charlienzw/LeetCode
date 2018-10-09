/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        HashMap<Integer,List<List<Integer>>> map=new HashMap<>();
        helper(root,map,0,0);
        Set<Integer> set=map.keySet();
        Iterator<Integer> iter=set.iterator();
        List<Integer> index=new ArrayList<>();
        while(iter.hasNext())
        {
            index.add(iter.next());
        }
        Collections.sort(index);
        List<List<Integer>> temp;
        List<Integer> r;
        for(int i=0;i<index.size();i++)
        {
            temp=map.get(index.get(i));
            Collections.sort(temp,new Comparator<List<Integer>>(){public int compare(List<Integer> a,List<Integer> b){return a.get(1)-b.get(1);}});
            r=new ArrayList<>();
            for(int j=0;j<temp.size();j++)
            {
                r.add(temp.get(j).get(0));
            }
            res.add(r);
        }
        return res;
    }
    public void helper(TreeNode root,HashMap<Integer,List<List<Integer>>> map,int pos,int h)
    {
        if(root!=null)
        {
            if(!map.containsKey(pos))
            {
                List<List<Integer>> temp=new ArrayList<>();
                List<Integer> l=new ArrayList<>();
                l.add(root.val);
                l.add(h);
                temp.add(l);
                map.put(pos,temp);
            }
            else
            {
                List<List<Integer>> temp=map.get(pos);
                List<Integer> l=new ArrayList<>();
                l.add(root.val);
                l.add(h);
                temp.add(l);
                map.put(pos,temp);
            }
            helper(root.left,map,pos-1,h+1);
            helper(root.right,map,pos+1,h+1);
        }
    }
}