package DSA_Refrehser;

import java.util.*;

public class Day09_StringDynamicProgramming {

    // =========================
    // 1. Edit Distance
    // =========================
    public int editDistance(int i, int j, String w1, String w2, int[][] memo) {

        if (i == w1.length()) return w2.length() - j;
        if (j == w2.length()) return w1.length() - i;

        if (memo[i][j] != -1) return memo[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return memo[i][j] = editDistance(i + 1, j + 1, w1, w2, memo);
        }

        int insert = editDistance(i, j + 1, w1, w2, memo);
        int delete = editDistance(i + 1, j, w1, w2, memo);
        int replace = editDistance(i + 1, j + 1, w1, w2, memo);

        return memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) Arrays.fill(row, -1);
        return editDistance(0, 0, word1, word2, memo);
    }


    // =========================
    // 2. Longest Common Subsequence (LCS)
    // =========================
    public int lcs(int i, int j, String a, String b, int[][] memo) {

        if (i == a.length() || j == b.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (a.charAt(i) == b.charAt(j)) {
            return memo[i][j] = 1 + lcs(i + 1, j + 1, a, b, memo);
        }

        return memo[i][j] = Math.max(
                lcs(i + 1, j, a, b, memo),
                lcs(i, j + 1, a, b, memo)
        );
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) Arrays.fill(row, -1);
        return lcs(0, 0, text1, text2, memo);
    }


    // =========================
    // 3. Longest Palindromic Subsequence
    // (Bottom-up DP)
    // =========================
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // length = 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (len == 2 ? 0 : dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


    // =========================
    // MAIN METHOD (TEST CASES)
    // =========================
    public static void main(String[] args) {

        Day09_StringDynamicProgramming sol = new Day09_StringDynamicProgramming();

        // ---- Test 1: Edit Distance ----
        String w1 = "horse";
        String w2 = "ros";
        System.out.println("Edit Distance (" + w1 + ", " + w2 + ") = "
                + sol.minDistance(w1, w2)); // expected 3

        // ---- Test 2: LCS ----
        String a = "abcde";
        String b = "ace";
        System.out.println("LCS = " + sol.longestCommonSubsequence(a, b)); // expected 3

        // ---- Test 3: Longest Palindromic Subsequence ----
        String s = "bbbab";
        System.out.println("LPS = " + sol.longestPalindromeSubseq(s)); // expected 4

        // ---- Extra tests ----
        System.out.println("Edit Distance (intention, execution) = "
                + sol.minDistance("intention", "execution"));

        System.out.println("LCS (abc, abc) = "
                + sol.longestCommonSubsequence("abc", "abc"));

        System.out.println("LPS (cbbd) = "
                + sol.longestPalindromeSubseq("cbbd"));
    }
}
