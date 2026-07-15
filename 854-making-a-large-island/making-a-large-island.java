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

        if(ulp_u==ulp_v){
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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                int mrow[] = {-1,0,1,0};
                int mcol[] = {0,1,0,-1};
                for(int k=0;k<4;k++){
                    int nrow = i+mrow[k];
                    int ncol = j+mcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        int nodeNo = i*n+j;
                        int adnodeNo = nrow*n+ncol;
                        ds.unionBySize(nodeNo, adnodeNo);
                    }
                }
            }

        }

        int mx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                int mrow[] = {-1,0,1,0};
                int mcol[] = {0,1,0,-1};
                HashSet<Integer> st = new HashSet<>();
                for(int k=0;k<4;k++){
                    int nrow = i+mrow[k];
                    int ncol = j+mcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        st.add(ds.findUParent(nrow*n+ncol));
                    }
                }
                int sizeTotal =0 ;
                for(int it: st){
                    sizeTotal+=ds.size.get(it);
                }
                mx=Math.max(sizeTotal+1, mx);
            }

        }
        for(int i=0;i<n*n;i++){
            mx=Math.max(mx, ds.size.get(ds.findUParent(i)));
        }
        return mx;
    }
}