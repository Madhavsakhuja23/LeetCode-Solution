class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }

}
class Solution {
    public int makeConnected(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtra =0 ;
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findUParent(u)==ds.findUParent(v)){
                cntExtra++;
            }else{
                ds.unionBySize(u, v);
            }
        }
        int cntCompo =0 ;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                cntCompo++;
            }
        }
        int ans = cntCompo-1;
        if(cntExtra>=ans){
            return ans;
        }
        return -1;
    }
}