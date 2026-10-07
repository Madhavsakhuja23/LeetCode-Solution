class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(int c =1;c<10;c++){
                        if(isValid(board,i,j,c)==true){
                            board[i][j]=(char)(c+'0');
                            if(solve(board)==true){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, int c){
        for(int r=0;r<board.length;r++){
            if(board[r][j]==(char)(c+'0')){
                return false;
            }
        }

        for(int col=0;col<board[0].length;col++){
            if(board[i][col]==(char)(c+'0')){
                return false;
            }
        }

        int rs = (i/3)*3;
        int cs =(j/3)*3;

        for(int k=rs;k<rs+3;k++){
            for(int l=cs;l<cs+3;l++){
                if(board[k][l]==(char)(c+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}