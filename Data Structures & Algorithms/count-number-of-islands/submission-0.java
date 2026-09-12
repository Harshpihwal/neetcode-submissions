class Solution {
    int[] a={1,0,-1,0};
    int[] b={0,1,0,-1};
    public int numIslands(char[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int[][] vis=new int[n][m];
       int c=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
             if(grid[i][j]=='1' && vis[i][j]==0){
                c++;
                dfs(i,j,vis,grid);
             }
        }
       }
       return c;
    }
    private void dfs(int r,int c,int[][] vis,char[][] grid){
        vis[r][c]=1;
        for(int i=0;i<4;i++){
            int nr=r+a[i];
            int nc=c+b[i];
            int m=grid.length;
            int n=grid[0].length;
            if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                dfs(nr,nc,vis,grid);
            }
        }
    }
}
