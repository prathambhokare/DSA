package LEETCODEPOTD;

public class Solution62 {
    public int helper(int i, int j, int[] piles, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int alice = piles[i] + helper(i + 1, j, piles, dp);
        int bob = piles[j] + helper(i, j - 1, piles, dp);

        return dp[i][j] = Math.max(alice, bob);
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        return helper(0, n - 1, piles, dp) > 0;
    }
}
