class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> lis = new ArrayList<>();
            res.add(lis);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    lis.add(1);
                }else{
                    lis.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
        }
        return res.get(rowIndex);
    }
}