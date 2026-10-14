class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
       PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[1], b[1]));
        for(int i=0;i<n;i++){
            double a[] = new double[2];
            a[0]=i;
            a[1]=Math.sqrt(Math.pow(points[i][0]-0, 2)+Math.pow(points[i][1]-0, 2));
            pq.offer(a);
        }
        int res[][] = new int[k][2];
        int q=0;
        while(!pq.isEmpty() && k!=0){
            double a[] = pq.poll();
            res[q]=points[(int)(a[0])];
            k--;
            q++;
        }
        return res;
    }
}