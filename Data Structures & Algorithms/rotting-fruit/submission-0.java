class Solution {
    class Pair{
        int r=0;
        int c=0;
        int tm=0;
        Pair(int r,int c,int tm){
            this.r=r;
            this.c=c;
            this.tm=tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cntfresh=0;
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        }

        int cnt=0;
        int[] a={0,1,0,-1};
        int[] b={-1,0,1,0};
        int tm=0;
        while(!queue.isEmpty()){
            int r=queue.peek().r;
            int c=queue.peek().c;
            int t=queue.peek().tm;
            tm=Math.max(t,tm);
            queue.remove();
            for(int i=0;i<4;i++){
                int nr=r+a[i];
                int nc=c+b[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    queue.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntfresh){
            return -1;
        }
        return tm;
    }
}
