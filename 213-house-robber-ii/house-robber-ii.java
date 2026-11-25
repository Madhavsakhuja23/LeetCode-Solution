class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int first[] = new int[n-1];
        int last[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            first[i]=nums[i];
        }
        for(int i=0;i<n-1;i++){
            last[i] = nums[i+1];
        }
        return Math.max(solve(first), solve(last));
    }
    public int solve(int[] nums) {
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