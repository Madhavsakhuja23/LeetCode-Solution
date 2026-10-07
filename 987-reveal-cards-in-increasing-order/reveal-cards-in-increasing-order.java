class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int indx = deck.length -1;
        Deque<Integer> q = new LinkedList<>();
        q.offer(deck[indx--]);
        while(indx>=0){
            int n = q.pollLast();
            q.offerFirst(n);
            q.offerFirst(deck[indx--]);
        }
        int res[] = new int[deck.length];
        for(int i=0;i<deck.length;i++){
            res[i]=q.poll();
        }
        return res;
    }
}