package DSA_Refrehser;

import java.util.*;

public class Day08_PartitionDynamicProgramming {

    // =========================
    // 1. MATRIX CHAIN MULTIPLICATION
    // =========================
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + (arr[i - 1] * arr[k] * arr[j]);

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    // =========================
    // 2. PALINDROME MIN CUT
    // =========================
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (isPalindrome(s, 0, i)) {
                dp[i] = 0;
            } else {
                for (int j = i; j >= 1; j--) {
                    if (isPalindrome(s, j, i)) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }

    // =========================
    // 3. SPLIT ARRAY (DP VERSION)
    // =========================
    static int splitArrayDP(int[] nums, int K) {
        int n = nums.length;
        int[][] dp = new int[n][K + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            dp[i][1] = prefix[i];

            for (int j = i; j >= 1; j--) {
                int sum = prefix[i] - prefix[j - 1];

                for (int k = 2; k <= K; k++) {
                    if (dp[j - 1][k - 1] != Integer.MAX_VALUE) {
                        dp[i][k] = Math.min(
                            dp[i][k],
                            Math.max(sum, dp[j - 1][k - 1])
                        );
                    }
                }
            }
        }

        return dp[n - 1][K];
    }

    // =========================
    // 4. SPLIT ARRAY (BINARY SEARCH)
    // =========================
    static boolean canSplit(int[] nums, int k, int mid) {
        int subarray = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > mid) {
                subarray++;
                sum = num;
                if (subarray > k) return false;
            } else {
                sum += num;
            }
        }
        return true;
    }

    static int splitArrayBinary(int[] nums, int k) {
        int lo = 0, hi = 0;

        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }

        int ans = hi;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    // =========================
    // MAIN (TEST CASES)
    // =========================
    public static void main(String[] args) {

        // -------- MCM --------
        System.out.println("MCM Tests:");
        System.out.println(matrixMultiplication(new int[]{40, 20, 30, 10, 30})); // 26000
        System.out.println(matrixMultiplication(new int[]{10, 20, 30})); // 6000

        // -------- Min Cut --------
        System.out.println("\nMin Cut Tests:");
        System.out.println(minCut("aab")); // 1
        System.out.println(minCut("a"));   // 0
        System.out.println(minCut("abccbc")); // 2

        // -------- Split Array DP --------
        System.out.println("\nSplit Array DP Tests:");
        System.out.println(splitArrayDP(new int[]{7,2,5,10,8}, 2)); // 18
        System.out.println(splitArrayDP(new int[]{1,2,3,4,5}, 2)); // 9

        // -------- Split Array Binary Search --------
        System.out.println("\nSplit Array Binary Tests:");
        System.out.println(splitArrayBinary(new int[]{7,2,5,10,8}, 2)); // 18
        System.out.println(splitArrayBinary(new int[]{1,2,3,4,5}, 2)); // 9
    }
}
