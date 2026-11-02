class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0;i<n;i++){
            xor=xor^nums[i];
        }

        int i =0;
        int m = xor;
        while(true){
            if((m & (1<<i))!=0){
                break;
            }
            i++;
        }

        int mask = (1<<i);
        int group1 =0;
        int group2 =0;
        for(int num: nums){
            if((num & mask)!=0){
                group1=group1^num;
            }else{
                group2=group2^num;
            }
        }

        return new int[]{group1, group2};
    }
}