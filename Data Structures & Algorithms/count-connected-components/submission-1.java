class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
    private void dfs(int i,List<List<Integer>> adj,int[] vis){
        vis[i]=1;
        for(int x:adj.get(i)){
            if(vis[x]==0){
                dfs(x,adj,vis);
            }
        }
    }
}
