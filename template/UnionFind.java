class UnionFind{
	private int[] parent;
	private int[] rank;
	private int count;
	public UnionFind(int n)
	{
		parent = new int[n];
		rank = new int[n];
		for(int i = 0; i < n; i++)
		{
			parent[i] = i;
			rank[i] = 1;
		}
		count = n;
	}
	public int find(int p)
	{
		return p != parent[p] ? parent[p] = find(parent[p]) : p;
	}
	public void union(int p, int q)
	{
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot)
		{
			return;
		}
		if(rank[pRoot] < rank[qRoot])
		{
			parent[pRoot] = qRoot;
		}
		else if(rank[pRoot] > rank[qRoot])
		{
			parent[qRoot] = pRoot;
		}
		else
		{
			parent[pRoot] = qRoot;
			rank[qRoot]++;
		}
	}
	public void show()
	{
		System.out.println("UnionFind:");
		for(int i = 0; i < count; i++)
		{
			System.out.println(i + " parent: " + parent[i] + " rank: " + rank[i]);
		}
	}
	public static void main(String[] Args)
	{
		UnionFind uf = new UnionFind(5);
		uf.show();
		uf.union(0, 1);
		uf.show();
		uf.union(1, 4);
		uf.show();
		uf.union(2, 3);
		uf.show();
		uf.union(0, 2);
		uf.show();
		uf.union(1, 3);
		uf.show();
		uf.union(0, 3);
		uf.show();
	}
}
