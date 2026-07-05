class Solution {
    public int reverse(int x) {
        if (x < 0) {
            long ans = -solve(-x);
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) ans;
        }
        long ans = solve(x);
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }

    public long solve(int n) {
        long r = 0;
        while (n > 0) {
            r = r * 10 + n % 10;
            n=n/10;
        }
        return r;
    }
}
