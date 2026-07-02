class Pair {
    int i;
    int j;
    int dis;

    Pair(int d, int x, int y) {
        i = x;
        j = y;
        dis = d;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        int dist[][] = new int[n][n];
        for (int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0, 0));
        dist[0][0] = 1;
        int mrow[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int mcol[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.i;
            int col = curr.j;
            int d = curr.dis;
            for (int i = 0; i < 8; i++) {
                int nrow = row + mrow[i];
                int ncol = col + mcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && d + 1 < dist[nrow][ncol]
                        && grid[nrow][ncol] == 0) {
                    dist[nrow][ncol] = d + 1;
                    q.add(new Pair(d + 1, nrow, ncol));
                }
            }
        }
        if (dist[n - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[n - 1][n - 1];
    }
}