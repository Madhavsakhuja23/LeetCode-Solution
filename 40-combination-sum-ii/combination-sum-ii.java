class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans = new HashSet<>();
        solve(0,target, candidates, new ArrayList<>(), ans);
        for(List<Integer> a: ans){
            res.add(a);
        }
        return res;
    }
    public void solve(int i, int target, int[] cand, List<Integer> arr, HashSet<List<Integer>> res){
        
        if (target == 0) {
            res.add(new ArrayList<>(arr));
            return;
        }

        if (i == cand.length || target < 0) {
            return;
        }
        if(cand[i]<=target){
            arr.add(cand[i]);
            solve(i+1, target-cand[i], cand,arr,res);
            arr.remove(Integer.valueOf(cand[i]));
        }
        int next = i;
         while (next < cand.length && cand[next] == cand[i]) {
            next++;
        }

        solve(next, target, cand, arr, res);
    }

}