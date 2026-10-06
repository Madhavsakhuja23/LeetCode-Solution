class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char brd[]: board){
            Arrays.fill(brd, '.');
        }
        List<List<String>> res = new ArrayList<>();
        solve(board,res,0);
        return res;
    }
    public void solve(char board[][], List<List<String>> res, int r){
        if(r==board.length){
            res.add(boardToString(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isValid(board,r,i)==true){
                board[r][i]='Q';
                solve(board,res,r+1);
                board[r][i]='.';
            }
        }
    }
    public boolean isValid(char board[][], int r, int c){
        for(int i=0;i<board.length;i++){
            if(board[r][i]=='Q'){
                return false;
            }
        }

        for(int i=0;i<board.length;i++){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        for(int i=r-1, j=c-1;i>=0 && j>=0;i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r-1,j=c+1;i>=0 &&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<String> boardToString(char board[][]){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            ans.add(row);
        }
        return ans;
    }
}