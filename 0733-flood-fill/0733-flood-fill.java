class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][] = image;
        int iniColour = image[sr][sc];
        int mrow[] = {-1,0,1,0};
        int mcol[] = {0,1,0,-1};
        dfs(sr,sc,image,ans,mrow,mcol,iniColour,color);
        return ans;
    }
    public void dfs(int row, int col, int[][] image, int ans[][], int mrow[], int mcol[], int iC, int c){
        ans[row][col]=c;
        int n=image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = row+mrow[i];
            int ncol=col+mcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iC && ans[nrow][ncol]!=c){
                dfs(nrow,ncol,image,ans,mrow,mcol,iC,c);
            }
        }
    }
}