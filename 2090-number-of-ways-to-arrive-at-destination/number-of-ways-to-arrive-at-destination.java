class Pair {
    int n;
    long w;

    Pair(int node, long wt) {
        n = node;
        w = wt;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        long dis[] = new long[n];
        int way[] = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        Arrays.fill(way, 0);
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        dis[0] = 0;
        way[0] = 1;
        q.add(new Pair(0, 0));
        int mod = (int) (1e9 + 7);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.n;
            long wt = curr.w;
            if (wt > dis[node]) {
                continue;
            }

            for (Pair it : adj.get(node)) {
                int adjNode = it.n;
                long adjWt = it.w;

                if (wt + adjWt < dis[adjNode]) {
                    dis[adjNode] = wt + adjWt;
                    q.add(new Pair(adjNode, dis[adjNode]));
                    way[adjNode] = way[node];
                } else if (wt + adjWt == dis[adjNode]) {
                    way[adjNode] = (way[adjNode] + way[node]) % mod;
                }
            }
        }
        return way[n - 1] % mod;

    }
}