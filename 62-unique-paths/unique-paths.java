class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int it[] : dp){
            Arrays.fill(it, -1);
        }
        return solve(m-1,n-1,dp);
    }
    public int solve(int i, int j, int dp[][]){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int dr[] ={-1,0};
        int dc[] = {0,-1};
        int paths = 0;
        for(int k=0;k<2;k++){
            int ni = i+dr[k];
            int nj = j+dc[k];
            if(ni>=0 && nj>=0){
                paths = paths+solve(ni,nj,dp);
            }
        }
        return dp[i][j] = paths;
    }
}