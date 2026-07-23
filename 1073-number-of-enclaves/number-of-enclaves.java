class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int it[] : vis){
            Arrays.fill(it, 0);
        }
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && vis[0][i]==0){
                vis[0][i]=1;
                q.add(new Pair(0, i));
            }
            if(grid[n-1][i]==1 && vis[n-1][i]==0){
                vis[n-1][i]=1;
                q.add(new Pair(n-1, i));
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                vis[i][0]=1;
                q.add(new Pair(i,0));
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                vis[i][m-1]=1;
                q.add(new Pair(i, m-1));
            }
        }

        int mrow[] = {-1,0,1,0};
        int mcol[] ={0,1,0,-1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for(int i=0;i<4;i++){
                int nrow = x+mrow[i];
                int ncol = y+mcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
class Pair{
    int x;
    int y;
    Pair(int i, int j){
        x=i;
        y=j;
    }
}