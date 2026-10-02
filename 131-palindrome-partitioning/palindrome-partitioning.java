class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s,0,res, new ArrayList<>());
        return res;
    }
    public void solve(String s, int i, List<List<String>> res , List<String> semi){
        if(i==s.length()){
            res.add(new ArrayList<>(semi));
            return;
        }
        for(int j=i;j<s.length();j++){
            String sub = s.substring(i,j+1);
            if(isPalindrome(sub)==true){
                semi.add(sub);
                solve(s,j+1,res,semi);
                semi.remove(semi.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
}