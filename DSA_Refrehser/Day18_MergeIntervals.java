package DSA_Refrehser;

import java.util.*;

public class Day18_MergeIntervals {

    // -----------------------------
    // 1. MERGE INTERVALS (line sweep style attempt)
    // -----------------------------
    public int[][] merge(int[][] intervals) {

        List<Integer[]> ans = new ArrayList<>();

        int[][] timeline = new int[intervals.length * 2][2];
        int k = 0;

        for (int i = 0; i < intervals.length; i++) {
            timeline[k][0] = intervals[i][0];
            timeline[k][1] = 1;

            timeline[k + 1][0] = intervals[i][1] + 1;
            timeline[k + 1][1] = -1;

            k += 2;
        }

        Arrays.sort(timeline, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int sum = 0;
        int start = -1;

        for (int i = 0; i < timeline.length; i++) {

            sum += timeline[i][1];

            if (start == -1) {
                start = timeline[i][0];
            }

            if (sum == 0) {
                ans.add(new Integer[]{start, timeline[i][0] - 1});
                start = -1;
            }
        }

        int[][] res = ans.stream()
                .map(l -> Arrays.stream(l).mapToInt(i -> i).toArray())
                .toArray(int[][]::new);

        return res;
    }

    // -----------------------------
    // 2. CAN ATTEND MEETINGS (line sweep)
    // -----------------------------
    static boolean canAttend(int[][] arr) {

        int[][] timeline = new int[arr.length * 2][2];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            timeline[k][0] = arr[i][0];
            timeline[k][1] = 1;

            timeline[k + 1][0] = arr[i][1] - 1;
            timeline[k + 1][1] = -1;

            k += 2;
        }

        Arrays.sort(timeline, (a, b) -> a[0] - b[0]);

        int cnt = 0;

        for (int i = 0; i < timeline.length; i++) {
            cnt += timeline[i][1];

            if (cnt > 1) return false;
        }

        return true;
    }

    // -----------------------------
    // 3. ERASE OVERLAP INTERVALS (GREEDY)
    // -----------------------------
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Day18_MergeIntervals sol = new Day18_MergeIntervals();

        // -------------------------
        // TEST 1: Merge Intervals
        // -------------------------
        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println("Merged Intervals:");
        int[][] merged = sol.merge(intervals1);
        for (int[] m : merged) {
            System.out.println(Arrays.toString(m));
        }

        // -------------------------
        // TEST 2: Can Attend Meetings
        // -------------------------
        int[][] intervals2 = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println("\nCan Attend Meetings:");
        System.out.println(Day18_MergeIntervals.canAttend(intervals2)); // false

        int[][] intervals3 = {
                {5, 8},
                {9, 12}
        };

        System.out.println(Day18_MergeIntervals.canAttend(intervals3)); // true

        // -------------------------
        // TEST 3: Erase Overlaps
        // -------------------------
        int[][] intervals4 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        System.out.println("\nErase Overlaps:");
        System.out.println(sol.eraseOverlapIntervals(intervals4)); // expected: 1
    }
}
