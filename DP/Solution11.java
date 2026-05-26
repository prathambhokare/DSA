package DP;

import java.util.*;

public class Solution11 {

    public static int minimumCostRequiredToConnectServers(int N, int[] costA, int[] costB) {
        // __minimum cost required to connect N servers
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            int monolithCost = 0;
            for (int j = i; j >= 0; j--) {
                // __consider current server as microservice
                monolithCost = monolithCost + costB[j];
                // CASE 1:
                // current server alone as microservice
                if (j == i) {
                    if (j == 0) {
                        dp[i] = costA[i];
                    }
                    else if (dp[j - 1] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(
                                dp[i],
                                costA[i] + dp[j - 1]);
                    }
                }
                // CASE 2:
                // monolith block size >= 2
                else {
                    if (j == 0) {
                        dp[i] = Math.min(
                                dp[i],
                                monolithCost);
                    }
                    else if (dp[j - 1] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(
                                dp[i],
                                monolithCost + dp[j - 1]);
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[N - 1];
    }

    public static void main(String[] args) {
        int ans = minimumCostRequiredToConnectServers(5, new int[] { 3, 5, 2, 1, 9 }, new int[] { 1, 1, 10, 5, 3 });
        System.out.println(ans);
    }
}
