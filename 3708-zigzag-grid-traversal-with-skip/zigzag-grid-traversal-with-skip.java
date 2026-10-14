class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<m;i++){
           if(i%2==0){
                 for(int j=0;j<n;j++){
                if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)){
                    res.add(grid[i][j]);
                }
            }
           }else{
             for(int j=n-1;j>=0;j--){
                if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)){
                    res.add(grid[i][j]);
                }
            }
           }
        }

        return res;
    }
}