class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i], i);
        }
        for(int i=0;i<n;i++){
            int x = target - nums[i];
            if(mp.containsKey(x) && mp.get(x)!=i){
                return new int[]{mp.get(x), i};
            }
        }
        return new int[] {};
    }
}