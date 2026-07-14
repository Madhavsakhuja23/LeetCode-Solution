class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(isSorted(nums)){
            return true;
        }
        int k=1;
        while(k<n){
            int tmp[] = new int[n];
            int j=0;
            for(int i=n-k;i<n;i++){
                tmp[j++]=nums[i];
            }
            for(int i=0;i<n-k;i++){
                tmp[j++]=nums[i];
            }
            if(isSorted(tmp)){
                return true;
            }
            k++;
        }
        return false;
    }
    public boolean isSorted(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}