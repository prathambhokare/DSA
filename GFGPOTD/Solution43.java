public class Solution43 {
    Boolean[][] dp;
    boolean solve(int i, int[] arr, int k, int rem, boolean taken) {
        if (i == arr.length) {
            return taken && rem == 0;
        }
        if (dp[i][rem] != null) {
            return dp[i][rem];
        }
        boolean take = solve(i + 1, arr, k,
                (rem + arr[i]) % k, true);
        boolean skip = solve(i + 1, arr, k, rem, taken);
        return dp[i][rem] = take || skip;
    }

    public boolean divisibleByK(int[] arr, int k) {
        dp = new Boolean[arr.length][k];
        return solve(0, arr, k, 0, false);
    }
}
