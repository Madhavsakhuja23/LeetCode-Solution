class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int it: nums){
            st.add(it);
        }
        return !(st.size()==nums.length);
    }
}