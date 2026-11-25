class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int res[][] = image;
        int initialColor = image[sr][sc];
        solve(sr,sc,image,res,color,initialColor);
        return res;
    }
    public void solve(int i, int j, int image[][], int res[][], int color, int initialColor){
        res[i][j]=color;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};

        for(int k=0;k<4;k++){
            int nrow = i+drow[k];
            int ncol = j+dcol[k];
            if(nrow>=0 && ncol>=0 && nrow<image.length && ncol<image[0].length && image[nrow][ncol]==initialColor && res[nrow][ncol]!=color){
                solve(nrow,ncol,image,res,color,initialColor);
            }
        }
    }
}