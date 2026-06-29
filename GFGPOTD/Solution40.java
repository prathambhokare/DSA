public class Solution40 {
    
    Integer[][][] dp;
    public int solve(int i, int j, int[] a, int[] b, int k) {
        if (k < 0) {
            return Integer.MIN_VALUE;
        }
        if (i == a.length) {
            if (j == b.length && k == 0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if (j == b.length) {
            if (a.length - i == k) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        int ans1 = solve(i + 1, j + 1, a, b, k);
        if (ans1 != Integer.MIN_VALUE) {
            ans1 = a[i] * b[j] + ans1;
        }
        ans1 = Math.max(
                ans1,
                solve(i + 1, j, a, b, k - 1)
        );
        return dp[i][j][k] = ans1;
    }

    public int maxDotProduct(int[] a, int[] b) {
        int k = a.length - b.length;
        dp = new Integer[a.length + 1][b.length + 1][k + 1];
        return solve(0, 0, a, b, k);
    }
}
