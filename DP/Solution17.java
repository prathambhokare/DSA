package DP;

import java.util.*;

public class Solution17 {

    // __Subarray DP Questions
    // 1. Count Number Of Palidromic Substring
    // 2. Count Number Of Palindromic Subsequences
    // 3. Burst Ballon Problem

    public static int longestPalindromeSubseq(String s) {
        int ans = 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        // __length sub. 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // __length sub. 2,3,4,5,6,7,8,9.....
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static int maxCoins(int[] nums) {
        int ans = 0;
        int[] num = new int[nums.length + 2];
        num[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            num[i + 1] = nums[i];
        }
        num[nums.length + 1] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        // __calculate for length==1
        // Range is from 1..1, 2..2, 3..3, 4..4, 5..5, 6..6, 7..7, 8..8, 9..9;
        int m = 1;
        while (m <= nums.length) {
            dp[m][m] = num[m - 1] * num[m] * num[m + 1];
            m = m + 1;
        }
        // __calculate for all length=2,3,4,5,6,7,8,9.......
        int len = 2;
        for (len = 2; len <= nums.length; len++) {

            for (int i = 1; i + len - 1 <= nums.length; i++) {
                int j = i + len - 1;
                // [i.......j]
                // now fix every k which is to be destroyed at the last compute it's cost
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j], dp[i][k - 1] + dp[k + 1][j]
                                    + (num[i - 1] * num[k] * num[j + 1]));
                }
            }
        }
        return dp[1][nums.length];
    }

    public static int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] score = new int[n][n];
        int[][] dp = new int[n][n];
        // length = 1
        int m = 0;
        while (m < n) {
            score[m][m] = nums[m];
            dp[m][m] = nums[m];
            m++;
        }
        // length = 2,3,4,5,...
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // XOR score of exactly nums[i..j]
                score[i][j] = score[i][j - 1]
                        ^ score[i + 1][j];
                // maximum score of any subarray inside [i..j]
                dp[i][j] = Math.max(
                        score[i][j],
                        Math.max(
                                dp[i + 1][j],
                                dp[i][j - 1]));
            }
        }
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];
            ans[q] = dp[l][r];
        }
        return ans;
    }

    public static int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        boolean[][] isPal = new boolean[s.length()][s.length()];
        // calculate for length 1
        int m = 0;
        while (m < s.length()) {
            dp[m][m] = 1;
            isPal[m][m] = true;
            m = m + 1;
        }
        // calculate for length=2,3,4,5,6,7,8,9.....
        for (int len = 2; len <= s.length(); len = len + 1) {
            // traverse through every subarray of length=len
            for (int i = 0; i + len - 1 < s.length(); i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }

                dp[i][j] = dp[i + 1][j]
                        + dp[i][j - 1]
                        - dp[i + 1][j - 1];

                if (isPal[i][j]) {
                    dp[i][j] += 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        int ans = maxCoins(new int[] { 3, 1, 5, 8 });
        System.out.println(ans);
        // Longest Palindromic Subsequence
        System.out.println("Longest Palindromic Subsequence:");
        System.out.println(longestPalindromeSubseq("bbbab")); // 4
        System.out.println(longestPalindromeSubseq("cbbd")); // 2
        System.out.println();

        // Count Palindromic Substrings
        System.out.println("Count Palindromic Substrings:");
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
        System.out.println();

        // Burst Balloons
        System.out.println("Burst Balloons:");
        System.out.println(maxCoins(new int[] { 3, 1, 5, 8 })); // 167
        System.out.println(maxCoins(new int[] { 1, 5 })); // 10
        System.out.println();

        // Maximum XOR Score Subarray Queries
        System.out.println("Maximum XOR Score Subarray Queries:");

        int[] nums1 = { 2, 8, 4, 32, 16, 1 };
        int[][] queries1 = {
                { 0, 2 },
                { 1, 4 },
                { 0, 5 }
        };

        System.out.println(
                Arrays.toString(
                        maximumSubarrayXor(nums1, queries1))); // [12, 60, 60]

        int[] nums2 = { 0, 7, 3, 2, 8, 5, 1 };
        int[][] queries2 = {
                { 0, 3 },
                { 1, 5 },
                { 2, 4 },
                { 2, 6 },
                { 5, 6 }
        };

        System.out.println(
                Arrays.toString(
                        maximumSubarrayXor(nums2, queries2))); // [7, 14, 11, 14, 5]
    }
}
