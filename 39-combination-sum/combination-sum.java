class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res =new ArrayList<>();
        solve(0,target,new ArrayList<>(), res, candidates);
        return res;
    }
    public void solve(int i, int target, List<Integer> arr, List<List<Integer>> res, int[] cand){
        if(i==cand.length){
            if(target==0){
                res.add(new ArrayList<>(arr));
            }
            return;
        }
        if(cand[i]<=target){
            arr.add(cand[i]);
            solve(i, target-cand[i],arr,res,cand);
            arr.remove(Integer.valueOf(cand[i]));
        }
        solve(i+1, target,arr,res,cand);
    }
}