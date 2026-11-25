class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            int not_pick = 0 + dp[i-1];
            if(i>1){
                pick = nums[i] + dp[i-2];
            }
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[n-1];
    }
   
}