class Solution {
    public int fib(int n) {
        return solve(n);
    }
    public int solve(int i){
        if(i==0 || i==1){
            return i;
        }
        return solve(i-1)+solve(i-2);
    }
}