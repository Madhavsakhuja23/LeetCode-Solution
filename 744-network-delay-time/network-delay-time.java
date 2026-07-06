class Pair{
    int n;
    int w;
    Pair(int node, int wt){
        n=node;
        w=wt;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.w-b.w);
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.n;
            int wt = curr.w;
            for(Pair it: adj.get(node)){
                int adjNode = it.n;
                int adjWt = it.w;

                if(adjWt+wt < dis[adjNode]){
                    dis[adjNode]=adjWt+wt;
                    q.add(new Pair(adjNode, dis[adjNode]));
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans, dis[i]);
        }
        return ans;
    }
}