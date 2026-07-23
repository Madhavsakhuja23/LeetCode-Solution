class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int ans[] = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        for(int i =0;i<numCourses;i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[cnt++]=node;

            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(cnt<numCourses-1){
            return new int[0];
        }
        return ans;
    }
}