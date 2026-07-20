class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(buyPrice<prices[i]){
                int profit = prices[i]-buyPrice;
                ans=Math.max(profit, ans);
            }else{
                buyPrice=prices[i];
            }
        }
        return ans;
    }
}