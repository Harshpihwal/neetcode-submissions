class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            int u=edge[0];
            int k=edge[1];
            adj.get(u).add(k);
        }

        int[] indegree=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int x:adj.get(i)){
                indegree[x]++;
            }
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int c=0;
        while(!queue.isEmpty()){
            int node=queue.remove();
            c++;
            for(int x:adj.get(node)){
                indegree[x]--;
                if(indegree[x]==0){
                    queue.add(x);
                }
            }
        }
        return c==n;
    }
}
