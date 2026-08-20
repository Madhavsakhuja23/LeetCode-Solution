class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> temp = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int n1 = intervals[i][0];
            int n2 = intervals[i][1];

            if (n1 <= max) {
                max = Math.max(max, n2);
            } else {
                int arr[] = new int[2];
                arr[0] = min;
                arr[1] = max;
                temp.add(arr);
                min = n1;
                max = n2;
            }
        }
        int arr[] = new int[2];
        arr[0] = min;
        arr[1] = max;
        temp.add(arr);
        int ans[][] = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i][0] = temp.get(i)[0];
            ans[i][1] = temp.get(i)[1];
        }
        return ans;
    }
}