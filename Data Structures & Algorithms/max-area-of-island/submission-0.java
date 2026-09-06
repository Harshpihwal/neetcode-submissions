class Solution {
    class Pair {
        int f = 0;
        int s = 0;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int s = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (!vis[i][j] && grid[i][j] == 1) {
                   int k=bfs(i, j, vis, grid);
                   s=Math.max(k,s);
                }
        }
        return s;
    }

    private int bfs(int i, int j, boolean[][] vis, int[][] grid) {
        int s=1;
        vis[i][j] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        int[] a = { 1, 0, -1, 0 };
        int[] b = { 0, -1, 0, 1 };
        int m = grid.length;
        int n = grid[0].length;
        while (!queue.isEmpty()) {
            int r = queue.peek().f;
            int c = queue.peek().s;
            queue.remove();
            for (int k = 0; k < 4; k++) {
                int nr = r + a[k];
                int nc = c + b[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && grid[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    s++;
                    queue.add(new Pair(nr, nc));
                }
            }
        }
        return s;
    }
}

