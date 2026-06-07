package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day11_LISDPVariation {
    

    // ---------------- BITONIC SEQUENCE ----------------
    public static int[] lisFromLeft(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    // --> 1. Bitonic Sequence
    //      prefix LIS + suffix LIS
    // --> 2. Russian Doll Envelopes
    //      sort + LIS on height
    // --> 3. Largest Divisible Subset
    //      DP + parent reconstruction

    public static int[] lisFromRight(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int longestBitonicSequence(int n, int[] nums) {
        int[] left = lisFromLeft(nums);
        int[] right = lisFromRight(nums);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (left[i] > 1 && right[i] > 1) {
                ans = Math.max(ans, left[i] + right[i] - 1);
            }
        }

        return ans;
    }

    // ---------------- RUSSIAN DOLL ENVELOPES ----------------

    public int lowerBound(List<Integer> list, int h) {
        int i = 0, j = list.size() - 1;
        int ans = list.size();

        while (i <= j) {
            int mid = (i + j) / 2;

            if (list.get(mid) >= h) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;
    }

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> tails = new ArrayList<>();

        for (int[] env : envelopes) {
            int h = env[1];

            if (tails.isEmpty() || h > tails.get(tails.size() - 1)) {
                tails.add(h);
            } else {
                int idx = lowerBound(tails, h);
                tails.set(idx, h);
            }
        }

        return tails.size();
    }

    // ---------------- LARGEST DIVISIBLE SUBSET ----------------

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (maxIdx != -1) {
            ans.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        Collections.reverse(ans);
        return ans;
    }
}
