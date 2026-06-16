import java.util.*;

class Solution34 {

    /* -------------------------------
       1. XOR CONSTRUCT LIST PROBLEM
       Pattern: Lazy XOR / Global Mask
    -------------------------------- */
    public ArrayList<Integer> constructList(int[][] queries) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        int xorMask = 0;

        for (int[] q : queries) {

            if (q[0] == 0) {
                list.add(q[1] ^ xorMask);
            } else {
                xorMask ^= q[1];
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) ^ xorMask);
        }

        Collections.sort(list);
        return list;
    }

    /* -----------------------------------
       2. MAX PRODUCT (INTEGER BREAK)
       Pattern: DP / Partition Optimization
    ------------------------------------ */

    public int maxproduct(int n, int[] dp) {

        if (n == 0) return 1;
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int ans = 0;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,
                    Math.max(i * (n - i), i * maxproduct(n - i, dp)));
        }

        return dp[n] = ans;
    }

    public int maxProduct(int n) {

        if (n <= 3) return n - 1;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return maxproduct(n, dp);
    }

    /* Optional main for testing */
    public static void main(String[] args) {

        Solution34 sol = new Solution34();

        // ---------------- XOR TEST ----------------
        int[][] q1 = {{0, 6}, {0, 3}, {0, 2}, {1, 4}, {1, 5}};
        System.out.println(sol.constructList(q1)); // [1, 2, 3, 7]

        int[][] q2 = {{0, 2}, {1, 3}, {0, 5}};
        System.out.println(sol.constructList(q2)); // [1, 3, 5]

        // --------------- MAX PRODUCT TEST ----------------
        System.out.println(sol.maxProduct(2));  // 1
        System.out.println(sol.maxProduct(3));  // 2
        System.out.println(sol.maxProduct(4));  // 4
        System.out.println(sol.maxProduct(10)); // 36
    }
}
