package DSA_Refrehser;

import java.util.*;

public class Day17_Greedy {

    // ==========================
    // Gas Station
    // ==========================
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalCost > totalGas) {
            return -1;
        }

        int ansval = 0;

        for (int i = 0; i < gas.length - 1; i++) {
            if (gas[i] - cost[i] + ansval < 0) {
                ansval = 0;
                ans = i + 1;
            } else {
                ansval += gas[i] - cost[i];
            }
        }

        return ans;
    }

    // ==========================
    // Jump Game
    // ==========================
    public boolean canJump(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] > ans) {
                ans = i + nums[i];
            }

            if (ans == i) {
                return false;
            }
        }

        return true;
    }

    // ==========================
    // Partition Labels
    // ==========================
    public boolean isPresentOnLeft(int idx, String ansval, String s) {
        Set<Character> set = new HashSet<>();

        for (int i = idx; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for (int i = 0; i < ansval.length(); i++) {
            if (set.contains(ansval.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        String ansval = "";

        for (int i = 0; i < s.length(); i++) {
            ansval = ansval + s.charAt(i);

            if (!isPresentOnLeft(i + 1, ansval, s)) {
                ans.add(ansval.length());
                ansval = "";
            }
        }

        return ans;
    }

    // ==========================
    // Main Method
    // ==========================
    public static void main(String[] args) {

        Day17_Greedy sol = new Day17_Greedy();

        // --------------------------
        // Gas Station Test Cases
        // --------------------------
        System.out.println("Gas Station:");

        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println(sol.canCompleteCircuit(gas1, cost1)); // Expected: 3

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println(sol.canCompleteCircuit(gas2, cost2)); // Expected: -1

        // --------------------------
        // Jump Game Test Cases
        // --------------------------
        System.out.println("\nJump Game:");

        int[] jump1 = {2, 3, 1, 1, 4};
        System.out.println(sol.canJump(jump1)); // Expected: true

        int[] jump2 = {3, 2, 1, 0, 4};
        System.out.println(sol.canJump(jump2)); // Expected: false

        int[] jump3 = {0};
        System.out.println(sol.canJump(jump3)); // Expected: true

        // --------------------------
        // Partition Labels Test Cases
        // --------------------------
        System.out.println("\nPartition Labels:");

        String s1 = "ababcbacadefegdehijhklij";
        System.out.println(sol.partitionLabels(s1)); // Expected: [9, 7, 8]

        String s2 = "eccbbbbdec";
        System.out.println(sol.partitionLabels(s2)); // Expected: [10]

        String s3 = "abc";
        System.out.println(sol.partitionLabels(s3)); // Expected: [1, 1, 1]
    }
}
