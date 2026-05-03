package DP;

import java.util.*;

public class Solution7 {

    public static int maximumEarnings(int[] cityA,int[] cityB) {
        int ans=0;
        int n=cityA.length;
        int[][] dp=new int[n][3];//_maximum earning on ith day
        dp[0][0]=cityA[0];//__maximum earning when on schedule for cityA
        dp[0][1]=cityB[0];//__maximum earning when on schedule for cityB
        dp[0][2]=0;//__maximum earning when transfer from cityA to cityB or cityB to cityA
        for (int i=1;i<dp.length;i++) {
            dp[i][0]=cityA[i] + Math.max(
                dp[i-1][0],//__last max earning from same cityA
                dp[i-1][2]//__last max earning from other city
            );
            dp[i][1]=cityB[i] + Math.max(
                dp[i-1][1],
                dp[i-1][2] 
            );
            dp[i][2]=0+Math.max(
                dp[i-1][0],
                dp[i-1][1]
            );
        }
        ans=Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
        return ans;
    }

    public static void main(String[] args) {
        int ans=maximumEarnings(new int[]{23,4,5,101}, new int[]{21,1,10,100});
        // int ans=maximumEarnings(new int[]{25,10,15,10,70}, new int[]{5,5,50,5,30});
        //____ ATBTA
        //__ 25 + 0 + 50 + 0 + 70 => 120+25 => 145
        System.out.println(ans);
    }
}
