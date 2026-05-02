package DP;

import java.util.*;

public class Solution5 {

    //__Minimum cost required to frog jump from 0th stone to Nth store while allowing jump upto K steps
    //__cost incurred by each step is |hk-hi|
    public static int minimumCost(int[] height,int k) {
        int ans=0;
        int[] dp=new int[height.length];//__minimum cost required for frog to jump to ith stone
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=Math.abs(height[1]-height[0]);
        for (int i=2;i<height.length;i++) {
            //jump upto 'K' steps
            for (int j=1;j<=k;j++) {
                if ((i-j)>=0) {
                    System.out.println(Math.abs(height[i]-height[i-j]));
                    dp[i]=Math.min(dp[i],Math.abs(height[i]-height[i-j])+dp[i-j]);
                }
                else {
                    break;
                }
            }
        }
        for (int i=0;i<dp.length;i++) {
            System.out.print(dp[i]+ " ");
        }
        System.out.println();
        ans=dp[height.length-1];
        return ans;
    }

    public static void main(String[] args) {
        int ans=minimumCost(new int[]{40,10,20,70,80,10,20,70,80,60}, 4);
        System.out.println(ans);
    }
}
