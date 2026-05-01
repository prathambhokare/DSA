package DP;

import java.util.*;

public class Solution3 {

    //__longest valid substring with difference between adjacent character is at most k
    public static String longestValidSubstring(String str,int k) {
        String ans="";
        int[] dp=new int[str.length()];//__longest valid for index i with adjacent character difference is at most k
        Arrays.fill(dp, 1);
        for (int i=1;i<str.length();i++) {
            if (Math.abs(str.charAt(i)-str.charAt(i-1))<=k) {
                dp[i]=1+dp[i-1];//__If Difference Is AtMost K Then Update Length By One
            }
            else {
                dp[i]=1;
            }
        }
        int maxIndex=0;
        int maxVal=dp[0];
        for (int i=1;i<dp.length;i++) {
            if (dp[i]>maxVal) {
                maxVal=dp[i];
                maxIndex=i;
            }
        }
        ans=str.substring(maxIndex-maxVal+1, maxIndex+1);
        return ans;
    }
    public static void main(String[] args) {
        String ans=longestValidSubstring("ababbaca", 1);
        System.out.println(ans);
    }    
}
