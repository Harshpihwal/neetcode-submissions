class Solution {
    class ponk{
        int f=0;
        int s=0;
        int t=0;
        ponk(int f,int s,int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
    class Pair{
        int f=0;
        int s=0;
        Pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++) dist[i]=(int)1e9;
        dist[src]=0;
        Queue<ponk> q=new LinkedList<>();
        q.add(new ponk(0,src,0));
        while(!q.isEmpty()){
            ponk te=q.remove();
            int st=te.f;
            int node=te.s;
            int d=te.t;
            if(st>k) continue;
            for(Pair x:adj.get(node)){
                int adjnode=x.f;
                int v=x.s;
                if(d+v<dist[adjnode] && st<=k){
                    dist[adjnode]=d+v;
                    q.add(new ponk(st+1,adjnode,d+v));
                }
            }
        }
        if(dist[dst]==1e9) return -1;
        return dist[dst];
    }
}
