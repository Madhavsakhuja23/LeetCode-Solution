class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans[] = new int[n1];
        Stack<Integer> st = new Stack();
        HashMap<Integer, Integer> mp = new HashMap<>();
        st.push(nums2[n2-1]);
        mp.put(nums2[n2-1], -1);
        for(int i=n2-2;i>=0 ; i--){
            int value = nums2[i];
            while(!st.isEmpty() && value>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                mp.put(value, -1);
            }else{
                mp.put(value, st.peek());
            }
            st.push(value);
        }
        for(int i=0;i<n1;i++){
            ans[i] = mp.get(nums1[i]);
        }
        return ans;
    }
}