class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        int[] a={0,1,0,-1};
        int[] b={1,0,-1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr=i+a[k];
                        int nc=j+b[k];
                        if(nr<0 || nr>=n){
                            c++;
                        }
                        if(nc<0 || nc>=m){
                            c++;
                        }
                        if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0){
                            c++;
                        }
                    }
                }
            }
        }
        return c;
    }
}