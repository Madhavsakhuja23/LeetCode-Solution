class Solution {
    public void sortColors(int[] nums) {
      HashMap<Integer, Integer> mp = new HashMap<>();
      int n = nums.length;
      for(int i=0;i<n;i++){
        mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
      }  
      int k=0;
      for(int i=0;i<3;i++){
        int x = mp.getOrDefault(i, 0);
        if(x==0){
            continue;
        }
        for(int j=0;j<x;j++){
            nums[k++]=i;
        }
      }
    }
}