package DP;

import java.util.*;

public class Solution4 {

    //__find out minimum cost required to frog jump from stone '0' to stone 'n'
    //__while allow to take jump of one or two step which incurres cost of Math.abs(hj-hi)
    public static int minimumCost(int[] height) {
        int ans=0;
        int[] dp=new int[height.length];//__minimum cost required to frog reach ith stone when starting jump from stone 0
        dp[0]=0;//__base_case
        dp[1]=Math.abs(height[1]-height[0]);
        for (int i=2;i<height.length;i++) {
            dp[i]=Math.min(
                Math.abs(height[i]-height[i-1])+dp[i-1],
                Math.abs(height[i]-height[i-2])+dp[i-2]
            );
        }
        for (int i=0;i<dp.length;i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        ans=dp[height.length-1];
        return ans;
    }
    public static void main(String[] args) {
        int ans=minimumCost(new int[]{30,10,60,10,60,50});
        System.out.println(ans);
    }
}
