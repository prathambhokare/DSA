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

    public static void main(String[] args) {
        int ans=validGroups("12");
        System.out.println(ans);
    }
}
