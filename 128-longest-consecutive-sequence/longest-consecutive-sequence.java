class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int res =0;
        for(int ele: set){
            if(!set.contains(ele-1)){
                int len = 1;
                while(set.contains(ele+len)){
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}