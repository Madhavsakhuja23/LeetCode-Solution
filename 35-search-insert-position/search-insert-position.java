class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int ans = nums.length;
        if(target < nums[0]){
            return 0;
        }
        while(l<=r){
            int mid = l+((r-l)/2);
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                ans=mid+1;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}