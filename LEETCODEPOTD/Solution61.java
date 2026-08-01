package LEETCODEPOTD;

public class Solution61 {
    public boolean solve(int i, int j, int p1, int p2, boolean turn, int[] nums) {
        if (i > j) {
            return p1 >= p2;
        }
        if (turn) {
            return solve(i + 1, j, p1 + nums[i], p2, false, nums) ||
                   solve(i, j - 1, p1 + nums[j], p2, false, nums);
        } else {
            return solve(i + 1, j, p1, p2 + nums[i], true, nums) &&
                   solve(i, j - 1, p1, p2 + nums[j], true, nums);
        }
    }

    public boolean predictTheWinner(int[] nums) {
        return solve(0, nums.length - 1, 0, 0, true, nums);
    }
}
