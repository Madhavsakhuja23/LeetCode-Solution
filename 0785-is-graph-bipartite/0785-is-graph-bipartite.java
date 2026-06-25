class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int colour[] = new int[v];
        for(int i=0;i<v;i++){
            colour[i]=-1;
        }
        for(int i=0;i<v;i++){
            if(colour[i]==-1){
                if(!dfs(i,0, graph,colour)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int i, int c, int[][] graph, int colour[]){
        colour[i]=c;
        for(int it: graph[i]){
            if(colour[it]==-1){
                c=(colour[i]==0?1:0);
                if(dfs(it,c,graph,colour)==false){
                    return false;
                }
            }
            else if(colour[it]==colour[i]){
                return false;
            }
        }
        return true;
    }
}