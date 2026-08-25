class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[1], b[1]));
        int cnt =1;
        int prevEnd = points[0][1];
        int n = points.length;
        for(int i=1;i<n;i++){
            int cs = points[i][0];
            int ce = points[i][1];

            if(prevEnd < cs){
                cnt++;
                prevEnd = ce;
            }
        }
        return cnt;
    }
}