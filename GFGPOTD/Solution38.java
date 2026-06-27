import java.util.*;

public class Solution38 {
    static final int MOD = 1000000007;
    public static Integer[] memo;
    public static int solve(int n, int m) {
        //when n<m there only one way to place 1*m tiles
        if (n < m) {
            return 1;
        }
        //when n==m there only two ways to place 1*m tiles
        if (n == m) {
            return 2;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        //depends on
        // [1.Placed horizontal tile] => currentRow-1
        // [2.Placed vertical tiles]  => currentRow-columnLength
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
