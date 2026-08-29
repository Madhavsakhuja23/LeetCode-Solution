class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve(s,t,0,0);
    }
    public boolean solve(String s, String t, int i, int j){
        if(s.length()==i){
            return true;
        }
        if(t.length()==j){
            return false;
        }
        if(s.charAt(i)==t.charAt(j)){
            return solve(s,t,i+1,j+1);
        }
        return solve(s,t,i,j+1);
    }
}