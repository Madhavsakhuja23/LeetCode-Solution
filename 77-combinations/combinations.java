class Solution {
    public List<List<Integer>> combine(int n, int k) {
        HashSet<List<Integer>> res = new HashSet<>();
        gc(1,n,res,new ArrayList<>(),k);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }
    public void gc(int st, int n, HashSet<List<Integer>> res, List<Integer> temp, int k){
        if(temp.size()==k){
            Collections.sort(temp);
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=st;i<=n;i++){
            temp.add(i);
            gc(i+1,n,res,temp,k);
            temp.remove(temp.size()-1);
        }
    }
}