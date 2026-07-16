import java.util.Arrays;

public // class Solution {
//     public int ways(int n,int n1,int sum) {
//         if (n==0) {
//             if (sum==0) {
//                 return 1;
//             }
//             return 0;
//         }
//         if (sum<0) {
//             return;
//         }
//         int cnt=0;
//         for (int i=0;i<=9;i++) {
//             if (i==0 && n1==n) {
//                 continue;
//             }
//             cnt=cnt+ways(n-1,n1,sum-i);
//         }
//         return cnt;
//     }
//     public int countWays(int n, int sum) {
//         // code here
//         int ans=0;
//         ans=ways(n,n,sum);
//         if (ans==0) {
//             return -1;
//         }
//         return ans;
//     }
// };
    int[][] dp;

    public int ways(int n, int n1, int sum) {
        if (sum < 0) {
            return 0;
        }
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        int cnt = 0;
        for (int i = 0; i <= 9; i++) {
            if (i == 0 && n == n1) {
                continue;
            }
            cnt += ways(n - 1, n1, sum - i);
        }
        return dp[n][sum] = cnt;
    }

    public int countWays(int n, int sum) {
        dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = ways(n, n, sum);
        return ans == 0 ? -1 : ans;
    }
}