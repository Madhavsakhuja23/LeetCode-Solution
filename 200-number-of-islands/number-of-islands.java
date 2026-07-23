class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        for(int it[]: vis){
            Arrays.fill(it, 0);
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int i, int j, int vis[][], char grid[][]){
        int mrow[] = {-1,0,1,0};
        int mcol[] ={0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j]=1;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x;
            int y=curr.y;

            for(int ii=0;ii<4;ii++){
                int nrow = x+mrow[ii];
                int ncol = y+mcol[ii];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
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