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

last 3 years at DB i have worked
1. informatica workflow migration to spring based application in which i have led 10+ workflows end to end
   analysis and development which has save 400k euro and reducing sme dependancies
2. led complete analysis and development of ingestion of budget data into reporting which has replaces manual process saves data loading time from 2 days to 3 minutes
3. Automation of adjustment data load, which replace excel based manual data upload tool whih saves business user time required for data prepration reduces manual error reduces adjustment processing time to 
   result in faster reflect of pnl numbers in a reports
4. Design and develop resuable configs based workflow definition which has save reduces development and made testing easier
5. Built a Splunk dashboard with time-based log search for historical retrieval, empowering the SL2 team to self-serve monitoring,
   reducing manual effort, eliminating engineering dependency for log analysis, and accelerating incident detection and resolution.
6. Develop and Designed prevention outlier adjustment loading into system using outlier detection algorithm,which helps preventing wrong P&L 
   values reflect in reporting
7. Build Tableua Automation Utility to publish workbook to production which replacement of manual process reduces time to less than 1 minutes to publish workbook
8. Implemented alerts and monitoring for all services which detection of service failure and automated incident created which directly monitor by SL2 team