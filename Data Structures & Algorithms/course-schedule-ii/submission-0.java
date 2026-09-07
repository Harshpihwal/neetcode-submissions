class Solution {
    public int[] findOrder(int n, int[][] p) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:p){
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
        }

        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int x:adj.get(i)){
                indegree[x]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[n];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.remove();
            ans[idx]=node;
            idx++;
            for(int x:adj.get(node)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.add(x);
                }
            }
        }
        if(idx!=n){
            return new int[]{};
        }
        return ans;
    }
}
