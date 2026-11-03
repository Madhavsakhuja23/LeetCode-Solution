class Solution {
    public boolean canJump(int[] nums) {
        int maxindex =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>maxindex){
                return false;
            }
            maxindex = Math.max(maxindex, nums[i]+i);
        }       
        return true;
    }
}