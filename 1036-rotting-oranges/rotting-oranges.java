class Pair{
    int x;
    int y;
    int tm;
    Pair(int i, int j, int t){
        x=i;
        y=j;
        tm=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        for(int it[] : vis){
            Arrays.fill(it, 0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    cntFresh++;
                }
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=1;
                }
            }
        }
        int ans = 0;
        int Nfrsh = 0;
        int mrow[] = {-1,0,1,0};
        int mcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.x;
            int col = curr.y;
            int tm = curr.tm;
            ans = Math.max(tm, ans);

            for(int i=0;i<4;i++){
                int nrow = row+mrow[i];
                int ncol = col+mcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol, tm+1));
                    vis[nrow][ncol]=1;
                    Nfrsh++;
                }
            }
        }
        if(cntFresh!=Nfrsh){
            return -1;
        }
        return ans;
    }
}