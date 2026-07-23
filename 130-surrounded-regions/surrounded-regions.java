class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        for (int it[] : vis) {
            Arrays.fill(it, 0);
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && vis[0][i] == 0) {
                q.add(new Pair(0, i));
                vis[0][i] = 1;
            }
            if (board[n - 1][i] == 'O' && vis[n - 1][i] == 0) {
                q.add(new Pair(n - 1, i));
                vis[n - 1][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                q.add(new Pair(i, 0));
                vis[i][0] = 1;
            }
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                q.add(new Pair(i, m - 1));
                vis[i][m - 1] = 1;
            }
        }

        int mrow[] = { -1, 0, 1, 0 };
        int mcol[] = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for (int i = 0; i < 4; i++) {
                int nrow = x + mrow[i];
                int ncol = y + mcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
                        && board[nrow][ncol] == 'O') {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        for (char it[] : board) {
            Arrays.fill(it, 'X');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 1) {
                    board[i][j] = 'O';
                }
            }
        }

    }
}

class Pair {
    int x;
    int y;

    Pair(int i, int j) {
        x = i;
        y = j;
    }
}