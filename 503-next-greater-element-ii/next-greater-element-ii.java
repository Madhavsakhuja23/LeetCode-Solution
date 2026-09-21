class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack();
        Arrays.fill(ans, -1);
        for(int i=0;i<2*n;i++){
            int indx = i%n;
            while(!st.isEmpty() && nums[st.peek()] < nums[indx]){
                ans[st.pop()] = nums[indx]; 
            }
            if(i < n){
                st.push(indx);
            }
        }
        return ans;
    }
}