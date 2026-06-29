class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjrev = new ArrayList<>();
        int V = graph.length;
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            adjrev.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                adjrev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(int it:adjrev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}