class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                neg.add(nums[i]);
            }else{
                pos.add(nums[i]);
            }
        }
        int j=0, k=0, l=0;
        while(j<pos.size() && k<pos.size()){
            if(l%2==0){
                nums[l++]=pos.get(j++);
            }else{
                nums[l++]=neg.get(k++);
            }
        }
        while(j<pos.size()){
            nums[l++]=pos.get(j++);
        }
        while(k<pos.size()){
            nums[l++]=neg.get(k++);
        }
        return nums;
    }
}