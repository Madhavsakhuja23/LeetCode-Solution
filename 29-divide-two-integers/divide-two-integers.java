class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor ==-1){
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        boolean neg = (dividend<0) ^ (divisor<0);

        long q =0;
        while(a>=b){
            long temp = b;
            long mltiple = 1;

            while(a>=(temp<<1)){
                temp=temp<<1;
                mltiple= mltiple<<1;
            }
             q = q+mltiple;
             a=a-temp;
        }
        if(neg){
            return (int) -q;
        }
        return (int) q;
    }
}