package LEETCODEPOTD;

import java.util.Arrays;

public class Solution53 {
    public int mod = 1000000007;
    public int[][][] dp;
    public int n;
    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public int solve(int i, int gcd1, int gcd2, int[] nums) {

        if (i == n) {
            if (gcd1 != 0 && gcd1 == gcd2) {
                return 1;
            }
            return 0;
        }
        if (dp[i][gcd1][gcd2] != -1) {
            return dp[i][gcd1][gcd2];
        }
        long ans = 0;

        // 1. Ignore current element
        ans += solve(i + 1, gcd1, gcd2, nums);
        // 2. Put current element in first subsequence
        int newGcd1 = gcd(gcd1, nums[i]);
        ans += solve(i + 1, newGcd1, gcd2, nums);
        // 3. Put current element in second subsequence
        int newGcd2 = gcd(gcd2, nums[i]);
        ans += solve(i + 1, gcd1, newGcd2, nums);

        return dp[i][gcd1][gcd2] = (int)(ans % mod);
    }

    public int subsequencePairCount(int[] nums) {
        n = nums.length;
        dp = new int[n][201][201];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 200; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, 0, nums);
    }
}
