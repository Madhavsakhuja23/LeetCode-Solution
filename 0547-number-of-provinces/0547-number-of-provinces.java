class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int visited[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                cnt++;
                // dfs(i, adj, visited);
                bfs(i, adj, visited);
            }
        }
        return cnt;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int visited[]) {
        visited[node] = 1;
        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, adj, visited);
            }
        }
    }

    public void bfs(int node, ArrayList<ArrayList<Integer>> adj, int visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;
        while (!q.isEmpty()) {
            int n = q.poll();
            for (int it : adj.get(n)) {
                if (visited[it] == 0) {
                    q.add(it);
                    visited[it] = 1;
                }
            }
        }
    }
}