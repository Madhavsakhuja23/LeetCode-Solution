class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int visited[] = new int[n];
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i=0;i<graph.length;i++){
        //     for(int j=0;j<graph[i].length;j++){
        //         adj.get(i).add(j);
        //         adj.get(j).add(i);
        //     }
        // }
        int colour[] = new int[graph.length];
        Arrays.fill(colour, -1);
        for(int i=0;i<graph.length;i++){
            if(colour[i]==-1){
                if(bfs(i,graph,colour)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node , int[][] graph, int colour[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        colour[node]=0;
        while(!q.isEmpty()){
            int n= q.poll();
            for(int it: graph[n]){
                if(colour[it]==-1){
                    colour[it]=(colour[n]==0?1:0);
                    q.add(it);
                }else if(colour[it]==colour[n]){
                    return false;
                }
            }
        }
        return true;

    }
}