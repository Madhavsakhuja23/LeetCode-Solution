class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int ten = 0;
        for(int i=0;i<n;i++){
            int moneyByCustomer = bills[i];

            if(moneyByCustomer == 5){
                five++;
            }else if(moneyByCustomer==10){
                if(five>0){
                    five--;
                    ten++;
                }
                else{
                    return false;
                }
            }else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}