class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        return solve(s.toLowerCase(), 0, n - 1);
    }

    public boolean solve(String s, int i, int j) {
        char c1 = s.charAt(i);
        char c2 = s.charAt(j);
        if (i < j) {
            if (!Character.isLetterOrDigit(c1)) {
                i++;
                return solve(s, i, j);
            }
            if (!Character.isLetterOrDigit(c2)) {
                j--;
                return solve(s, i, j);
            }
            if (c1 != c2) {
                return false;
            }
            if (c1 == c2) {
                return solve(s, i+1, j-1);
            }
        }
        return true;
    }
}