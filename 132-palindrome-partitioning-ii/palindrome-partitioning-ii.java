import java.util.*;

class Solution {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(s, 0, dp) - 1;
    }

    public int solve(String s, int i, int[] dp) {

        // No characters remaining
        if (i == s.length()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); j++) {

            if (isPalindrome(s, i, j)) {

                int partitions = 1 + solve(s, j + 1, dp);

                ans = Math.min(ans, partitions);
            }
        }

        return dp[i] = ans;
    }

    public boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}