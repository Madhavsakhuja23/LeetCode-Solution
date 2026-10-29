class Solution {
    public int reverse(int x) {
        if(x<0){
            x=-x;
            long ans = -solve(x);
            if(ans<Integer.MIN_VALUE){
                return 0;
            }
            return (int)ans;
        }
        long res = solve(x);
        if(res>Integer.MAX_VALUE){
            return 0;
        }
        return (int) res;
    }
    public long solve(int n){
        long ans = 0;
        while(n>0){
            ans=ans*10+n%10;
            n=n/10;
        }
        return ans;
    }
}