class Solution {
    class cell{
        int x,y,val;
        cell(int xx,int yy,int vv)
        {
            x=xx;
            y=yy;
            val=vv;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {
        int x=A.length,y=A[0].length,z=B[0].length;
        HashMap<Integer,List<cell>> map=new HashMap<>();
        List<cell> list=new ArrayList<>();
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(A[i][j]!=0)
                {
                    if(!map.containsKey(j))
                    {
                        list=new ArrayList<>();
                        list.add(new cell(i,j,A[i][j]));
                        map.put(j,list);
                    }
                    else
                    {
                        list=map.get(j);
                        list.add(new cell(i,j,A[i][j]));
                        map.put(j,list);
                    }
                }
            }
        }
        int[][] res=new int[x][z];
        for(int j=0;j<y;j++)
        {
            for(int k=0;k<z;k++)
            {
                if(B[j][k]!=0)
                {
                    if(!map.containsKey(j)) continue;
                    list=map.get(j);
                    for(cell l:list)
                    {
                        res[l.x][k]=res[l.x][k]+B[j][k]*l.val;
                    }
                }
            }
        }
        return res;
    }
}