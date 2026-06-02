package LEETCODEPOTD;

public class Solution29 {
    
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                int landFinish = landStartTime[i] + landDuration[i];
                int waterBegin = Math.max(landFinish, waterStartTime[j]);
                ans = Math.min(ans, waterBegin + waterDuration[j]);

                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landBegin = Math.max(waterFinish, landStartTime[i]);
                ans = Math.min(ans, landBegin + landDuration[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
                // Example 1
        int[] landStart1 = {2, 8};
        int[] landDur1 = {4, 1};
        int[] waterStart1 = {6};
        int[] waterDur1 = {3};

        System.out.println(
            "Example 1 Output: " +
            earliestFinishTime(landStart1, landDur1, waterStart1, waterDur1)
        );
        // Expected: 9


        // Example 2
        int[] landStart2 = {5};
        int[] landDur2 = {3};
        int[] waterStart2 = {1};
        int[] waterDur2 = {10};

        System.out.println(
            "Example 2 Output: " +
            earliestFinishTime(landStart2, landDur2, waterStart2, waterDur2)
        );
        // Expected: 14


        // Additional Test Case 1
        int[] landStart3 = {1};
        int[] landDur3 = {5};
        int[] waterStart3 = {2};
        int[] waterDur3 = {2};

        System.out.println(
            "Test Case 3 Output: " +
            earliestFinishTime(landStart3, landDur3, waterStart3, waterDur3)
        );
        // Expected: 8
        // Water -> Land : 2->4, then Land 4->9
        // Land -> Water : 1->6, then Water 6->8 (best)


        // Additional Test Case 2
        int[] landStart4 = {10};
        int[] landDur4 = {1};
        int[] waterStart4 = {1};
        int[] waterDur4 = {1};

        System.out.println(
            "Test Case 4 Output: " +
            earliestFinishTime(landStart4, landDur4, waterStart4, waterDur4)
        );
        // Expected: 11
        // Water: 1->2, wait until 10, Land: 10->11


        // Additional Test Case 3
        int[] landStart5 = {1, 3};
        int[] landDur5 = {2, 5};
        int[] waterStart5 = {2, 4};
        int[] waterDur5 = {3, 1};

        System.out.println(
            "Test Case 5 Output: " +
            earliestFinishTime(landStart5, landDur5, waterStart5, waterDur5)
        );
    }
}
