package LEETCODEPOTD;

import java.util.*;

public class Solution30 {

    public int finishTime(int[] landStartTime,
                          int[] landDuration,
                          int[] waterStartTime,
                          int[] waterDuration) {

        int ans = Integer.MAX_VALUE;
        int finish1 = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            finish1 = Math.min(
                finish1,
                landStartTime[i] + landDuration[i]
            );
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            ans = Math.min(
                ans,
                Math.max(finish1, waterStartTime[i]) + waterDuration[i]
            );
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        int ans = finishTime(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        );

        int ansval = finishTime(
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        );

        return Math.min(ans, ansval);
    }

    public static void main(String[] args) {

        Solution30 sol = new Solution30();

        // Test Case 1
        System.out.println(
            sol.earliestFinishTime(
                new int[]{1},
                new int[]{2},
                new int[]{5},
                new int[]{3}
            )
        ); // Expected: 8

        // Test Case 2
        System.out.println(
            sol.earliestFinishTime(
                new int[]{2},
                new int[]{4},
                new int[]{1},
                new int[]{3}
            )
        ); // Expected: 8

        // Test Case 3
        System.out.println(
            sol.earliestFinishTime(
                new int[]{1, 5},
                new int[]{3, 1},
                new int[]{2, 4},
                new int[]{2, 3}
            )
        ); // Expected: 6

        // Test Case 4
        System.out.println(
            sol.earliestFinishTime(
                new int[]{1, 10},
                new int[]{10, 1},
                new int[]{1},
                new int[]{1}
            )
        ); // Expected: 11

        // Test Case 5
        System.out.println(
            sol.earliestFinishTime(
                new int[]{0},
                new int[]{5},
                new int[]{0},
                new int[]{4}
            )
        ); // Expected: 9
    }
}
