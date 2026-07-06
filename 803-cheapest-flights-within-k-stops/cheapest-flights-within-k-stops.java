class Pair{
    int first;
    int second;
    Pair(int f, int s){
        first=f;
        second=s;
    }
}
class Tuple{
    int first;
    int second;
    int third;
    Tuple(int f, int s, int t){
        first=f;
        second=s;
        third=t;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src]=0;
        // stops, node, dist
        q.add(new  Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int node = t.second;
            int di = t.third;
            int stps = t.first;
            if(stps>k){
                continue;
            }
            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int adjWt = it.second;

                if(di+adjWt < dis[adjNode]){
                    dis[adjNode]=di+adjWt;
                    q.add(new Tuple(stps+1, adjNode, dis[adjNode]));
                }
            }
        }
        if(dis[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dis[dst];
    }
}