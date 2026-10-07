class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.offer(i);
        }
        int time = 0;
        while(tickets[k]!=0){
            int idx = q.poll();
            tickets[idx]--;
            if(tickets[idx]!=0){
                q.offer(idx);
            }
            time++;
        }
        return time;
    }
}