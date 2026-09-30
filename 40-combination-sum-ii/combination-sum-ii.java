class Solution {

    public List<List<Integer>> combinationSum2(int[] arr, int t) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        solve(arr, res, new ArrayList<>(), t, 0);

        return res;
    }

    public void solve(int[] arr, List<List<Integer>> res,
                      List<Integer> semi, int t, int i) {

        if (t == 0) {
            res.add(new ArrayList<>(semi));
            return;
        }

        if (i == arr.length || t < 0) {
            return;
        }

        if (arr[i] <= t) {

            semi.add(arr[i]);

            solve(arr, res, semi, t - arr[i], i + 1);

            semi.remove(semi.size() - 1);
        }

        int next = i + 1;

        while (next < arr.length && arr[next] == arr[i]) {
            next++;
        }

        solve(arr, res, semi, t, next);
    }
}