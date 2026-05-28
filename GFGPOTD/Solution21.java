import java.util.*;

public class Solution21 {
    
    public static int validGroups(String s) {
        int n = s.length();
        // dp[i][sum] = ways till index i with last group sum = sum
        int[][] dp = new int[n][901];
        for (int i = 0; i < n; i++) {
            // form current group from j -> i
            int currSum = 0;
            for (int j = i; j >= 0; j--) {
                currSum += (s.charAt(j) - '0');
                // first group
                if (j == 0) {
                    dp[i][currSum] += 1;
                }
                else {
                    // previous group sum must be <= current group sum
                    for (int prevSum = 0; prevSum <= currSum; prevSum++) {
                        dp[i][currSum] += dp[j - 1][prevSum];
                    }
                }
            }
        }
        int ans = 0;
        for (int sum = 0; sum <= 900; sum++) {
            ans += dp[n - 1][sum];
        }
        return ans;
    }

    public static int validGroups(String s) {
        int n = s.length();
        // stores:
        // values[i] => (sum -> count of ways)
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] values = new Map[n];
        for (int i = 0; i < n; i++) {
            values[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // create current group from j -> i
            for (int j = i; j >= 0; j--) {
                sum += (s.charAt(j) - '0');
                // first group
                if (j == 0) {
                    values[i].put(sum,
                            values[i].getOrDefault(sum, 0) + 1);
                }
                else {
                    Map<Integer, Integer> prevMap = values[j - 1];
                    for (Map.Entry<Integer, Integer> entry : prevMap.entrySet()) {
                        int prevSum = entry.getKey();
                        int count = entry.getValue();
                        // non-decreasing condition
                        if (sum >= prevSum) {
                            values[i].put(sum,
                                    values[i].getOrDefault(sum, 0) + count);
                        }
                    }
                }
            }
        }

        int ans = 0;
        // total ways ending at last index
        for (int count : values[n - 1].values()) {
            ans += count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=validGroups("1119");
        System.out.println(ans);
    }
}


