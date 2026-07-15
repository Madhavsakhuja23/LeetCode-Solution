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

    public void UnionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(size.get(ulp_v)<size.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(mp.containsKey(mail)==false){
                    mp.put(mail, i);
                }else{
                    ds.UnionBySize(i, mp.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i=0;i<n;i++){
            mergeMail[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> it:mp.entrySet()){
            String mail = it.getKey();
            int node = ds.findUParent(it.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergeMail[i].size()==0) continue;
            Collections.sort(mergeMail[i]);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(i).get(0));
            for(String it: mergeMail[i]){
                tmp.add(it);
            }
            ans.add(tmp);
        }
        return ans;
    }
}