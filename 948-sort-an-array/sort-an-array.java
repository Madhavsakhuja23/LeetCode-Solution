class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i=n/2;i>=0;i--){
            heapify(nums,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int tmp = nums[i];
            nums[i]=nums[0];
            nums[0]=tmp;
            heapify(nums,i,0);
        }
        return nums;
    }

    public void heapify(int nums[], int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && nums[left]>nums[largest]){
            largest=left;
        }
        if(right<n && nums[right]>nums[largest]){
            largest=right;
        }
        if(largest!=i){
            int tmp = nums[largest];
            nums[largest]=nums[i];
            nums[i] = tmp;

            heapify(nums, n, largest);
        }
    }
}