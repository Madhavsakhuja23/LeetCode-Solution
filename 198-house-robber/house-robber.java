class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev =nums[0], prev2=0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            int not_pick = 0 + prev;
            if(i>1){
                pick = nums[i] + prev2;
            }
            int curri = Math.max(pick, not_pick);
            prev2 = prev;
            prev = curri; 
        }
        return prev;
    }
   
}