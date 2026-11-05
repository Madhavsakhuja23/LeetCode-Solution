class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int arrival[] = new int[n];
        int dep[] = new int[n];

        for(int i=0;i<n;i++){
            arrival[i] = intervals[i][0];
            dep[i] = intervals[i][1];
        }

        Arrays.sort(arrival);
        Arrays.sort(dep);

        int i=0;
        int j=0;
        int cnt =0;
        int maxCnt =0;
        while(i<n){
            if(arrival[i]<=dep[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }
}