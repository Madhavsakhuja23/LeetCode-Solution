class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int arr[] = new int[1001];
        Arrays.fill(arr, 0);
        int n = trips.length;
        for(int i=0;i<n;i++){
            int num_pass = trips[i][0];
             arr[trips[i][1]] += num_pass;
            arr[trips[i][2]] -= num_pass;
        }
        int c= 0;
        for(int i=0;i<1001;i++){
            c=c+arr[i];
            if(c>capacity){
                return false;
            }
        }
        return true;
    }
}