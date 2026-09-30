class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        HashSet<List<Integer>> res = new HashSet<>();
        int arr[]= {1,2,3,4,5,6,7,8,9};
        solve(arr,k,n,0,new ArrayList<>(),res);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> a: res){
            ans.add(a);
        }
        return ans;
    }

    public void solve(int arr[], int k, int t, int i, List<Integer> semi, HashSet<List<Integer>> res){
       
        if(t==0 && semi.size()==k){
            res.add(new ArrayList<>(semi));
        }
         if(i==arr.length || t<0){
            return;
        }
        if(arr[i]<=t){
            semi.add(arr[i]);
            solve(arr,k,t-arr[i],i+1,semi,res);
            semi.remove(Integer.valueOf(arr[i]));
        }
        solve(arr,k,t,i+1,semi,res);
    }

}