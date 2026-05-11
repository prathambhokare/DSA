package DP;

import java.util.*;

public class Solution9 {
    
    public static int solve(int i,int j,String s1,String s2) {

        if (i>=s1.length()) {
            return s2.length()-j;
        }

        if (j>=s2.length()) {
            return s1.length()-i;
        }
        
        if (s1.charAt(i)==s2.charAt(j)) {
            return solve(i+1, j+1, s1, s2);
        }
        return 1+Math.min(
            solve(i, j+1, s1, s2),//__Insert New Character
            Math.min(
                    solve(i+1, j, s1, s2),//Remove Character
                    solve(i+1, j+1, s1, s2)//Relace With Any Other Character
                )
        );
        //CASE_01: Insert Any Character 
        //CASE_02: Remove Any Character
        //CASE_03: Replace Any Character
        //CASE_04: When Both Characters Are Equal
    }
    //__Find Out Minimum Number Of Operations Required To Convert String s1 To String s2
    public static int solveTabulation(String s1,String s2) {
        int ans=0;
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[0].length;j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    //zero operations are required
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(
                        dp[i][j-1],
                        Math.min(dp[i-1][j],dp[i-1][j-1])
                    );
                }
            }
        }
        ans=dp[dp.length-1][dp[0].length-1];
        return ans;
    }
    public static int minimumOperationsRequired(String s1,String s2) {
        int ans=0;
        ans=solveTabulation(s1,s2);
        return ans;
    }
    public static void main(String[] args) {
        int ans=minimumOperationsRequired("geek", "gesek");
        System.out.println(ans);
    }
}
