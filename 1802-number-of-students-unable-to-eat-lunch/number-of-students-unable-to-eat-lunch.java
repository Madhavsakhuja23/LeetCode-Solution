class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<students.length;i++){
            q.offer(students[i]);
        }
        int indx =0;
        int t=0;
        while(!q.isEmpty()){
            int n = q.peek();
            if(n==sandwiches[indx]){
                t=0;
                q.poll();
                indx++;
            }
            else{
                q.poll();
                q.offer(n);
            }

            if(t==q.size()){
                return t;
            }
            t++;
        }
        return t;
    }
}