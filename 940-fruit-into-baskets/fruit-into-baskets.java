class Solution {
    public int totalFruit(int[] fruits) {
        int l=0,r=0,n=fruits.length, maxLen =0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(r<n){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);
            if(mp.size()>2){
                mp.put(fruits[l], mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            if(mp.size()<=2){
                int len = r-l+1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}