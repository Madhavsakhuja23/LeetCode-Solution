class Solution {
    public int maxProduct(int[] nums) {
        int preffix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(preffix==0){
                preffix=1;
            }
            if(suffix==0){
                suffix=1;
            }

            preffix=preffix*nums[i];
            suffix=suffix*nums[nums.length-1-i];

            ans = Math.max(ans, Math.max(preffix, suffix));
        }
        return ans;
    }
}