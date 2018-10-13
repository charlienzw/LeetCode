/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<Integer,UndirectedGraphNode> mapnode=new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        UndirectedGraphNode res=new UndirectedGraphNode(node.label);
        mapnode.put(res.label,res);
        for(int i=0;i<node.neighbors.size();i++)
        {
            if(!mapnode.containsKey(node.neighbors.get(i).label))
                res.neighbors.add(cloneGraph(node.neighbors.get(i)));
            else
                res.neighbors.add(mapnode.get(node.neighbors.get(i).label));
        }
        return res;
    }
}