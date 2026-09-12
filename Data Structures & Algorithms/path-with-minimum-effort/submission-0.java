class Solution {
    class Pair{
        int f=0;
        int s=0;
        int t=0;
        Pair(int f,int s,int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] a = {0, 1, 0, -1};
        int[] b = {1, 0, -1, 0};
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.f - y.f);
        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int d = temp.f;
            int r = temp.s;
            int c = temp.t;
            if (r == n - 1 && c == m - 1) {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + a[i];
                int nc = c + b[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int ne = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), d);
                    if (ne < dist[nr][nc]) {
                        dist[nr][nc] = ne;
                        pq.offer(new Pair(ne, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}