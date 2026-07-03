public class Solution44 {
    public int waysToIncreaseLCSBy1(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // pref[i][j] = LCS(s1[0..i-1], s2[0..j-1])
        int[][] pref = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    pref[i][j] = 1 + pref[i - 1][j - 1];
                } else {
                    pref[i][j] = Math.max(pref[i - 1][j], pref[i][j - 1]);
                }
            }
        }

        // suff[i][j] = LCS(s1[i...], s2[j...])
        int[][] suff = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    suff[i][j] = 1 + suff[i + 1][j + 1];
                } else {
                    suff[i][j] = Math.max(suff[i + 1][j], suff[i][j + 1]);
                }
            }
        }

        int lcs = pref[n][m];
        int ans = 0;

        // Try every insertion position
        for (int i = 0; i <= n; i++) {

            boolean[] used = new boolean[26];

            // Try matching inserted character with every position in s2
            for (int j = 0; j < m; j++) {

                char ch = s2.charAt(j);

                if (used[ch - 'a'])
                    continue;

                if (pref[i][j] + 1 + suff[i][j + 1] == lcs + 1) {
                    ans++;
                    used[ch - 'a'] = true;
                }
            }
        }

        return ans;
    }
}
