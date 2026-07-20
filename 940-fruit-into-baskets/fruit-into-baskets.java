class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int l=0,r=0,maxLen=0;
        int n = fruits.length;
        int k=2;
        while(r<n){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);
            if(mp.size()>k){
                mp.put(fruits[l], mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            if(mp.size()<=k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}