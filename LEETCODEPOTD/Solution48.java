package LEETCODEPOTD;

import java.util.List;

public class Solution48 {
    // class Solution {
//     public int mod = 1_000_000_007;
//     int[] ans = new int[2];

//     public void pathwithmaxscore(int idxR, int idxC, int n, int m,
//                                  List<String> board, int sum) {
//         if (idxR < 0 || idxC < 0) {
//             return;
//         }
//         if (board.get(idxR).charAt(idxC) == 'X') {
//             return;
//         }
//         if (idxR == 0 && idxC == 0) {
//             if (sum > ans[0]) {
//                 ans[0] = sum;
//                 ans[1] = 1;
//             } else if (sum == ans[0]) {
//                 ans[1] = (ans[1] + 1) % mod;
//             }
//             return;
//         }

//         if (idxC - 1 >= 0 &&
//             board.get(idxR).charAt(idxC - 1) != 'X') {
//             char ch = board.get(idxR).charAt(idxC - 1);
//             pathwithmaxscore(
//                 idxR,
//                 idxC - 1,
//                 n,
//                 m,
//                 board,
//                 sum + (ch == 'E' || ch == 'S' ? 0 : ch - '0')
//             );
//             }
//         if (idxR - 1 >= 0 &&
//             board.get(idxR - 1).charAt(idxC) != 'X') {
//             char ch = board.get(idxR - 1).charAt(idxC);
//             pathwithmaxscore(
//                 idxR - 1,
//                 idxC,
//                 n,
//                 m,
//                 board,
//                 sum + (ch == 'E' || ch == 'S' ? 0 : ch - '0')
//             );
//         }
//         if (idxR - 1 >= 0 &&
//             idxC - 1 >= 0 &&
//             board.get(idxR - 1).charAt(idxC - 1) != 'X') {
//             char ch = board.get(idxR - 1).charAt(idxC - 1);
//             pathwithmaxscore(
//                 idxR - 1,
//                 idxC - 1,
//                 n,a
//                 m,
//                 board,
//                 sum + (ch == 'E' || ch == 'S' ? 0 : ch - '0')
//             );
//         }
//     }

//     public int[] pathsWithMaxScore(List<String> board) {
//         ans = new int[]{0, 0};
//         int n = board.size();
//         int m = board.get(0).length();
//         pathwithmaxscore(n - 1, m - 1, n, m, board, 0);
//         return ans;
//     }
// }

// class Solution {
    // public int mod = 1_000_000_007;

    // Integer[][] score;
    // Integer[][] ways;

    // public int[] pathwithmaxscore(int idxR, int idxC, int n, int m,
    //                               List<String> board) {
    //     if (idxR < 0 || idxC < 0) {
    //         return new int[]{-1, 0};
    //     }
    //     if (board.get(idxR).charAt(idxC) == 'X') {
    //         return new int[]{-1, 0};
    //     }
    //     if (idxR == 0 && idxC == 0) {
    //         return new int[]{0, 1};
    //     }
    //     if (score[idxR][idxC] != null) {
    //         return new int[]{score[idxR][idxC], ways[idxR][idxC]};
    //     }
    //     int[] left = pathwithmaxscore(idxR, idxC - 1, n, m, board);
    //     int[] up = pathwithmaxscore(idxR - 1, idxC, n, m, board);
    //     int[] diag = pathwithmaxscore(idxR - 1, idxC - 1, n, m, board);
    //     int best = Math.max(left[0], Math.max(up[0], diag[0]));
    //     if (best == -1) {
    //         score[idxR][idxC] = -1;
    //         ways[idxR][idxC] = 0;
    //         return new int[]{-1, 0};
    //     }
    //     int cnt = 0;
    //     if (left[0] == best) {
    //         cnt = (cnt + left[1]) % mod;
    //     }
    //     if (up[0] == best) {
    //         cnt = (cnt + up[1]) % mod;
    //     }
    //     if (diag[0] == best) {
    //         cnt = (cnt + diag[1]) % mod;
    //     }
    //     char ch = board.get(idxR).charAt(idxC);
    //     int val = (ch == 'S' || ch == 'E') ? 0 : ch - '0';
    //     score[idxR][idxC] = best + val;
    //     ways[idxR][idxC] = cnt;
    //     return new int[]{score[idxR][idxC], ways[idxR][idxC]};
    // }

    

    // public int[] pathsWithMaxScore(List<String> board) {
    //     int n = board.size();
    //     int m = board.get(0).length();
    //     score = new Integer[n][m];
    //     ways = new Integer[n][m];
    //     int[] ans = pathwithmaxscore(n - 1, m - 1, n, m, board);
    //     if (ans[0] == -1) {
    //         return new int[]{0, 0};
    //     }
    //     return ans;
    // }
    public int mod = 1_000_000_007;
    Integer[][] dp;
    Integer[][] ways;

    public int maxScore(int r, int c, List<String> board) {
        if (r < 0 || c < 0)
            return Integer.MIN_VALUE;
        if (board.get(r).charAt(c) == 'X')
            return Integer.MIN_VALUE;
        if (r == 0 && c == 0)
            return 0;
        if (dp[r][c] != null)
            return dp[r][c];
        int left = maxScore(r, c - 1, board);
        int up = maxScore(r - 1, c, board);
        int diag = maxScore(r - 1, c - 1, board);
        int best = Math.max(left, Math.max(up, diag));
        if (best == Integer.MIN_VALUE)
            return dp[r][c] = Integer.MIN_VALUE;
        char ch = board.get(r).charAt(c);
        int val = (ch == 'S' || ch == 'E') ? 0 : ch - '0';
        return dp[r][c] = best + val;
    }

    public int countWays(int r, int c, List<String> board) {
        if (r < 0 || c < 0)
            return 0;
        if (board.get(r).charAt(c) == 'X')
            return 0;
        if (r == 0 && c == 0)
            return 1;
        if (ways[r][c] != null)
            return ways[r][c];
        int ans = 0;
        char ch = board.get(r).charAt(c);
        int val = (ch == 'S' || ch == 'E') ? 0 : ch - '0';
        int curr = maxScore(r, c, board);
        int left = maxScore(r, c - 1, board);
        int up = maxScore(r - 1, c, board);
        int diag = maxScore(r - 1, c - 1, board);
        if (left != Integer.MIN_VALUE && left + val == curr) {
            ans = (ans + countWays(r, c - 1, board)) % mod;
        }
        if (up != Integer.MIN_VALUE && up + val == curr) {
            ans = (ans + countWays(r - 1, c, board)) % mod;
        }
        if (diag != Integer.MIN_VALUE && diag + val == curr) {
            ans = (ans + countWays(r - 1, c - 1, board)) % mod;
        }
        return ways[r][c] = ans;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        dp = new Integer[n][n];
        ways = new Integer[n][n];
        int score = maxScore(n - 1, n - 1, board);
        if (score == Integer.MIN_VALUE)
            return new int[]{0, 0};
        int cnt = countWays(n - 1, n - 1, board);
        return new int[]{score, cnt};
    }
}
