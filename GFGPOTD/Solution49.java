public class Solution49 {
    int n, m;
    int[][] mat;
    boolean[][] stationP;
    boolean[][] stationQ;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int countCoordinates(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        m = mat[0].length;

        stationP = new boolean[n][m];
        stationQ = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            dfs(0, j, stationP);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0, stationP);
        }

        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, stationQ);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, stationQ);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (stationP[i][j] && stationQ[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, boolean[][] vis) {
        if (vis[r][c]) return;

        vis[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;

            if (!vis[nr][nc] && mat[nr][nc] >= mat[r][c]) {
                dfs(nr, nc, vis);
            }
        }
    }
}
