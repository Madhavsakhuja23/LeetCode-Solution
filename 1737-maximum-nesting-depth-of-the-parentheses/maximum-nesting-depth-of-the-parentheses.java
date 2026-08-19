class Solution {
    public int maxDepth(String s) {
        int p =0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                p++;
            }else if(s.charAt(i)==')'){
                p--;
            }
            ans=Math.max(ans, p);
        }
        return ans;
    }
}