package LEETCODEPOTD;

import java.util.*;

public class Solution13 {
    
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            int sum = a + b;
            diff[2] += 2;
            diff[a + 1] -= 1;
            diff[b + limit + 1] += 1;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }
        int ans = Integer.MAX_VALUE;
        int currentMoves = 0;
        for (int target = 2; target <= 2 * limit; target++) {
            currentMoves += diff[target];
            ans = Math.min(ans, currentMoves);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
