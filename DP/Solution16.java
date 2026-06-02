package DP;

import java.util.Arrays;

public class Solution16 {
    
    public int maximumProfit(int i,int[] prices,int[] dp) {

        if (i>=prices.length) {
            return 0;
        }

        if (dp[i]!=-1) {
            return dp[i];
        }
        
        int ans=0;
        for (int j=i;j<prices.length;j++) {
            if ((prices[j]-prices[i])>=0) {
                ans=Math.max(ans,(prices[j]-prices[i])+maximumProfit(j+1,prices,dp));
            }
        }
        dp[i]=ans;
        return ans;
    }
    public int maxProfit(int[] prices) {
        int ans=0;
        int[] dp=new int[prices.length];
        Arrays.fill(dp,-1);
        ans=maximumProfit(0,prices,dp);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
