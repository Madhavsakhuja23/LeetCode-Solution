class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        int f=0;
        int l=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(nums[i]+nums[j]==target){
                    f=i;
                    l=j;
                }
            }
        }
        arr[0]=f;
        arr[1]=l;
        return arr;
    }
}