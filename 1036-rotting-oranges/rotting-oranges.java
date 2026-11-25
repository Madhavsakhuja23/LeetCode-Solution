class Solution {
    public int orangesRotting(int[][] grid) {
        int res =0;
        int countFresh =0;
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }else{
                    visited[i][j]=0;
                    if(grid[i][j]==1){
                    countFresh++;
                    }
                }
            }
        }
        int rottened =0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            res = Math.max(res,p.time);

            int drow[] = {-1,0,1,0};
            int dcol[] ={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,p.time+1));
                    rottened++;
                }
            }
        }
        if(countFresh!=rottened){
            return -1;
        }
        return res;
    }
}
class Pair{
    int row;
    int col;
    int time;
    Pair(int r, int c,int t){
        row=r;
        col=c;
        time=t;
    }
}