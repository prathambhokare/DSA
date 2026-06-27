import java.util.*;

public class Solution38 {
    static final int MOD = 1000000007;
    public static Integer[] memo;
    public static int solve(int n, int m) {
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        return memo[n] =
                (solve(n - 1, m) + solve(n - m, m)) % MOD;
    }

    public static int countWays(int n, int m) {
        memo = new Integer[n + 1];
        return solve(n, m);
    }

    public static void main(String[] args) {
        int ans=countWays(4, 4);
        System.out.println(ans);
    }
}
