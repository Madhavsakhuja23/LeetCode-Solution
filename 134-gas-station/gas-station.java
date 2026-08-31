class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int strt =0;
        int total =0;
        int tank =0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            int diff = gas[i]-cost[i];
            tank+=diff;
            total+=diff;
            if(tank<0){
                tank=0;
                strt=i+1;
            }
        }
        if(total>=0){
            return strt;
        }
        return -1;
    }
}