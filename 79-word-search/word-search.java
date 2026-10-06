class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==(word.charAt(0))){
                    if(solve(board,word,i,j,0, visited)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean solve(char board[][], String word, int i, int j, int indx, boolean visited[][]){
        if(indx==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        if(visited[i][j]==true){
            return false;
        }
        if((board[i][j]!=(word.charAt(indx)))){
            return false;
        }
        visited[i][j]= true;
        boolean found =solve(board, word, i - 1, j, indx + 1, visited) || // up
                solve(board, word, i + 1, j, indx + 1, visited) || // down
                solve(board, word, i, j - 1, indx + 1, visited) || // left
                solve(board, word, i, j + 1, indx + 1, visited);   // right
        visited[i][j]=false;
        return found;
    }
}