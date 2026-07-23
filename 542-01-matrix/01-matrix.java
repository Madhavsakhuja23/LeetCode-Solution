class Node {
    int x;
    int y;
    int d;

    Node(int i, int j, int di) {
        x = i;
        y = j;
        d = di;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int vis[][] = new int[m][n];
        for (int it[] : vis) {
            Arrays.fill(it, 0);
        }
        int ans[][] = new int[m][n];
        for (int it[] : ans) {
            Arrays.fill(it, 0);
        }
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = 1;
                    q.add(new Node(i, j, 0));
                }
            }
        }
        int mrow[] = { -1, 0, 1, 0 };
        int mcol[] = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int d = curr.d;

            ans[x][y] = d;
            for (int i = 0; i < 4; i++) {
                int nrow = x + mrow[i];
                int ncol = y + mcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, d + 1));
                }
            }
        }
        return ans;
    }
}