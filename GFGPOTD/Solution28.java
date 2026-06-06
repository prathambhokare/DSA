public class Solution28 {
    public int numOfWays(int n, int m) {
        // code here
        int ans = 0;

        int[][] dir = {
                { -2, -1 }, { -2, 1 },
                { -1, -2 }, { -1, 2 },
                { 1, -2 }, { 1, 2 },
                { 2, -1 }, { 2, 1 }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int forbidden = 1; 

                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        forbidden++;
                    }
                }

                ans += (n * m - forbidden);
            }
        }
        return ans;
    }
}
