import java.util.*;

public class Day10_KnapsackDynamicProgramming {

    // =====================================================
    // 1. Painting the Walls (DP - reverse knapsack)
    // =====================================================
    int n;
    int[][] memoPaint;

    public int dfsPaint(int i, int remain, int[] cost, int[] time) {

        if (remain <= 0) return 0;
        if (i == n) return (int) 1e9;

        if (memoPaint[i][remain] != -1)
            return memoPaint[i][remain];

        int skip = dfsPaint(i + 1, remain, cost, time);
        int take = cost[i] + dfsPaint(i + 1, remain - time[i] - 1, cost, time);

        return memoPaint[i][remain] = Math.min(skip, take);
    }

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memoPaint = new int[n + 1][n + 1];

        for (int[] row : memoPaint)
            Arrays.fill(row, -1);

        return dfsPaint(0, n, cost, time);
    }


    // =====================================================
    // 2. 0/1 Knapsack (maximum cost)
    // =====================================================
    public int maximumcost(int i, int W, int[] val, int[] wt, int[][] memo) {

        if (i >= val.length) return 0;
        if (W <= 0) return 0;

        if (memo[i][W] != -1) return memo[i][W];

        int skip = maximumcost(i + 1, W, val, wt, memo);

        int take = 0;
        if (wt[i] <= W) {
            take = val[i] + maximumcost(i + 1, W - wt[i], val, wt, memo);
        }

        return memo[i][W] = Math.max(skip, take);
    }

    public int knapsack(int W, int val[], int wt[]) {

        int[][] memo = new int[val.length + 1][W + 1];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        return maximumcost(0, W, val, wt, memo);
    }


    // =====================================================
    // 3. Partition Equal Subset Sum
    // =====================================================
    public boolean isPossible(int i, int target, int[] nums, Boolean[][] memo) {

        if (target == 0) return true;
        if (i == nums.length) return false;
        if (target < 0) return false;

        if (memo[i][target] != null)
            return memo[i][target];

        boolean skip = isPossible(i + 1, target, nums, memo);
        boolean take = isPossible(i + 1, target - nums[i], nums, memo);

        return memo[i][target] = (skip || take);
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 != 0) return false;

        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];

        return isPossible(0, sum / 2, nums, memo);
    }


    // =====================================================
    // 4. Target Sum Ways (pure recursion)
    // =====================================================
    public int numberofways(int i, int[] nums, int target) {

        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        return numberofways(i + 1, nums, target + nums[i]) +
               numberofways(i + 1, nums, target - nums[i]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return numberofways(0, nums, target);
    }


    // =====================================================
    // MAIN METHOD (TEST CASES)
    // =====================================================
    public static void main(String[] args) {

        Day10_KnapsackDynamicProgramming sol = new Day10_KnapsackDynamicProgramming();

        // -------------------------------
        // Test 1: Paint Walls
        // -------------------------------
        int[] cost = {1, 2, 3, 2};
        int[] time = {1, 2, 3, 2};
        System.out.println("Paint Walls = " + sol.paintWalls(cost, time));
        // expected: 3

        // -------------------------------
        // Test 2: Knapsack
        // -------------------------------
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        System.out.println("Knapsack = " + sol.knapsack(50, val, wt));
        // expected: 220

        // -------------------------------
        // Test 3: Partition Equal Subset Sum
        // -------------------------------
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Can Partition = " + sol.canPartition(nums1));
        // expected: true

        // -------------------------------
        // Test 4: Target Sum Ways
        // -------------------------------
        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println("Target Sum Ways = " + sol.findTargetSumWays(nums2, 3));
        // expected: 5
    }
}