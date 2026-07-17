class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int vis[] = new int[n];
        int cnt = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j==i){
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    int u = i;
                    int v = j;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, vis, adj);
            }
        }
        return cnt;
    }

    public void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, vis, adj);
            }
        }
    }
}