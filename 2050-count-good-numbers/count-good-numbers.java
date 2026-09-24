class Solution {
    private static final long mod = 1000000007L;
    public int countGoodNumbers(long n) {
     long evenPositions = (n+1)/2;
     long oddPositions = n/2;
     long evenWays = modPower(5, evenPositions);   
     long oddWays = modPower(4, oddPositions);

     return (int)((evenWays*oddWays)%mod);   
    }

    public long modPower(long base, long exponent){
        long result =1;

        while(exponent>0){
            if(exponent%2==1){
                result= (result*base)%mod;
            }
            base = (base*base)%mod;
            exponent/=2;
        }
        return result;
    }
}