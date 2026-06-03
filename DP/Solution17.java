package DP;

import java.util.*;

public class Solution17 {

    //__Subarray DP Questions
    // 1. Count Number Of Palidromic Substring
    // 2. Count Number Of Palindromic Subsequences
    // 3. Burst Ballon Problem

    public static int maxCoins(int[] nums) {
        int ans=0;
        int[] num=new int[nums.length+2];
        num[0]=1;
        for (int i=0;i<nums.length;i++) {
            num[i+1]=nums[i];
        }
        num[nums.length+1]=1;
        int[][] dp=new int[nums.length+2][nums.length+2];
        //__calculate for length==1
        // Range is from 1..1, 2..2, 3..3, 4..4, 5..5, 6..6, 7..7, 8..8, 9..9;
        int m=1;
        while (m<=nums.length) {
            dp[m][m]=num[m-1]*num[m]*num[m+1];
            m=m+1;
        }
        //__calculate for all length=2,3,4,5,6,7,8,9.......
        int len=2;
        for (len = 2; len <= nums.length; len++) {

            for (int i=1;i+len-1<=nums.length;i++) {
                int j=i+len-1;
                //[i.......j]
                //now fix every k which is to be destroyed at the last compute it's cost
                for (int k=i;k<=j;k++) {
                    dp[i][j]=Math.max(
                        dp[i][j], dp[i][k-1]+dp[k+1][j]
                                  + (num[i-1]*num[k]*num[j+1]));
                }
            }
        }
        return dp[1][nums.length];
    }
    
    public static void main(String[] args) {
        int ans=maxCoins(new int[]{3,1,5,8});
        System.out.println(ans);
    }
}
