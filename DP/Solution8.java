package DP;

import java.util.*;

public class Solution8 {
    public static int solve(int i,int j,String s1,String s2) {

        if (i>=s1.length() || j>=s2.length()) {
            return 0;
        }

        if (s1.charAt(i)==s2.charAt(j)) {
            return 1+solve(i+1, j+1, s1, s2);
        }
        return Math.max(solve(i+1, j, s1, s2),solve(i, j+1, s1, s2));
    }
    public static int solveTabulation(String s1,String s2) {
        int ans=0;
        //__dp[i][j] is longest common subsequences of
            //__till ith index of string s1 and
            //__till jth index of string s2
        int[][] dp=new int[s1.length()][s2.length()];
        for (int i=0;i<dp.length;i++) {
            for (int j=0;j<dp[0].length;j++) {
                if (s1.charAt(i)==s2.charAt(j)) {
                    if ((i-1)<0 || (j-1)<0) {
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                }
                else {
                    dp[i][j]=Math.max(i-1<0 ? 0 : dp[i-1][j], j-1<0 ? 0 : dp[i][j-1]);
                }
            }
        }
        ans=dp[dp.length-1][dp[0].length-1];
        return ans;

    }
    public static int longestCommonSubsequences(String s1, String s2) {
        int ans=0;
        ans=solveTabulation(s1,s2);
        return ans;
    }
    public static void main(String[] args) {
        int ans=longestCommonSubsequences("adde", "fghj");
        System.out.println(ans);
    }
}
