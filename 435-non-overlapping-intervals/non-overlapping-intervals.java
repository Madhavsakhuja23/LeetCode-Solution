class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int prevE = intervals[0][1];
        int cnt=0;
        for(int i=1;i<intervals.length;i++){
            int cs = intervals[i][0];
            int ce = intervals[i][1];

            if(prevE>cs){
                cnt++;
            }else{
                prevE=ce;
            }
        }   
        return cnt;
    }
}