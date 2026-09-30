class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums,0,res,new ArrayList<>());
        return res;
    }
    public void solve(int nums[], int i, List<List<Integer>> res, List<Integer> semi){
        if(i==nums.length){
            res.add(new ArrayList<>(semi));
            return;
        }
        semi.add(nums[i]);
        solve(nums,i+1,res,semi);
        semi.remove(Integer.valueOf(nums[i]));
        solve(nums,i+1,res,semi);
    }
}