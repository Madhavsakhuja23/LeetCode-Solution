class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp =new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Integer> arr = new ArrayList<>(mp.keySet());
        Collections.sort(arr, (a,b)->mp.get(b)-mp.get(a));
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}