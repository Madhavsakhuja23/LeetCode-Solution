class Solution {
    public double myPow(double x, int n) {
        double ans = solve(x, Math.abs(n));
        if(n<0){
            return 1/ans;
        }
        return ans;
    }

    public double solve(double x, int n){
        if(n==0){
            return 1;
        }
        double half = solve(x, n/2);
        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }
}