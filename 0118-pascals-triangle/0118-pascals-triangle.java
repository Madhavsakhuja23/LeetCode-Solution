class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> lis = new ArrayList<>();
            res.add(lis);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    res.get(i).add(1); // for every last and the first column it will always 1 
                }else{
                    lis.add(res.get(i-1).get(j-1)+res.get(i-1).get(j)); // get the previous row get the previous colmun of that and then add with the previous row with same column number 
                }
            }
        }
        return res;
    }
}