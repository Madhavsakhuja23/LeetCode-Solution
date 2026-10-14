class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.offer(score[i]);
        }
        HashMap<Integer, String> mp = new HashMap<>();
        int j=0;
        while(pq.size()>0){
            if(j==0){
                mp.put(pq.poll(),"Gold Medal");
                j++;
                continue;
            }
            if(j==1){
                mp.put(pq.poll(),"Silver Medal");
                j++;
                continue;
            }
            if(j==2){
                mp.put(pq.poll(),"Bronze Medal");
                j++;
                continue;
            }
            mp.put(pq.poll(),String.valueOf(j+1));
            j++;
        }
        String res[] = new String[n];
        for(int i=0;i<n;i++){
            res[i]=mp.get(score[i]);
        }
        return res;
    }
}