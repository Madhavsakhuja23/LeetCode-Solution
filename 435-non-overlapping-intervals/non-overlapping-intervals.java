class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int ans = 0;
        int min = intervals[0][0];
        int max = intervals[0][1];
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            int n1 = intervals[i][0];
            int n2 = intervals[i][1];

            if (n1 < max) {
                ans++;
                max = Math.min(max, n2);
            } else {
                min = n1;
                max = n2;
            }
        }
        return ans;
    }
}