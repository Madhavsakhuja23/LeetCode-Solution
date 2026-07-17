class Pair{
    int x;
    int y;
    Pair(int i, int j){
        x=i;
        y=j;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int vis[][] = new int[n][m];
        int ans[][] = image;
        int iniColour = image[sr][sc];
        ans[sr][sc]=color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        vis[sr][sc]=1;
        int mrow[] = {-1,0,1,0};
        int mcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            vis[x][y]=1;
            for(int i=0;i<4;i++){
                int nrow= x+mrow[i];
                int ncol = y+mcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && ans[nrow][ncol]==iniColour){
                    ans[nrow][ncol]=color;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return ans;
    }
}