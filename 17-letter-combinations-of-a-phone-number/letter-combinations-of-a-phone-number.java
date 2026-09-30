class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,map,0,0,new StringBuilder(),res);
        return res;
    }
    public void solve(String digits, String[] map, int i, int j, StringBuilder semi, List<String> res){
        if(i==digits.length()){
            res.add(semi.toString());
            return;
        }
        String letters = map[digits.charAt(i)-'0'];

        if (j == letters.length()) {
            return;
        }
        char c = letters.charAt(j);

        semi.append(c);
        solve(digits, map, i + 1, 0, semi, res);
        semi.deleteCharAt(semi.length() - 1);
        solve(digits,map,i,j+1,semi,res);
    }
}