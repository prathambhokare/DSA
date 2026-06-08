package DSA_Refrehser;

import java.util.*;

public class Day12_DynamicProgrammingHardQuestions {

    // ===================== CHERRY PICKUP 741 =====================
    int n;
    int[][] grid;
    int[][][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        dp = new int[n][n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(dp[i][j][k], Integer.MIN_VALUE);
                }
            }
        }

        return Math.max(0, dfs(0, 0, 0, 0));
    }

    private int dfs(int r1, int c1, int r2, int c2) {

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) return Integer.MIN_VALUE;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1 && r2 == n - 1 && c2 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != Integer.MIN_VALUE)
            return dp[r1][c1][r2][c2];

        int cherries = (r1 == r2 && c1 == c2)
                ? grid[r1][c1]
                : grid[r1][c1] + grid[r2][c2];

        int best = Integer.MIN_VALUE;

        best = Math.max(best, dfs(r1 + 1, c1, r2 + 1, c2));
        best = Math.max(best, dfs(r1 + 1, c1, r2, c2 + 1));
        best = Math.max(best, dfs(r1, c1 + 1, r2 + 1, c2));
        best = Math.max(best, dfs(r1, c1 + 1, r2, c2 + 1));

        if (best == Integer.MIN_VALUE) return dp[r1][c1][r2][c2] = Integer.MIN_VALUE;

        return dp[r1][c1][r2][c2] = cherries + best;
    }

    // ===================== BURST BALLOONS 312 =====================
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // len = 1
        for (int i = 1; i <= n; i++) {
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;

                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i][k - 1] + dp[k + 1][j] + (arr[i - 1] * arr[k] * arr[j + 1])
                    );
                }
            }
        }

        return dp[1][n];
    }
}
