class Pair{
    int i;
    int j;
    Pair(int x, int y){
        i=x;
        j=y;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n=matrix[0].length;
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    st.add(new Pair(i, j));
                }
            }
        }
        while(!st.isEmpty()){
            Pair curr = st.pop();
            int x=curr.i;
            int y=curr.j;

            for(int i=0;i<m;i++){
                matrix[i][y]=0;
            }
            for(int i=0;i<n;i++){
                matrix[x][i]=0;
            }
        }
    }
}