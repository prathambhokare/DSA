package DP;

import java.util.*;

public class Solution6 {
    
    //__Minimum cost required to reduce 'N' to '1' when allow to perform below operations
    //____1. Reduce number by 1 will cost y dollars
    //____2. Reduce number by /7 will cost x dollars
    //____3. Reduce number by /3 will cost z dollars
    //____4. Reduce number by /5 will cost b dollars
    public static int minimumCost(int n,int y,int x, int z,int b) {
        int ans=0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<=n;i++) {
            dp[i]=Math.min(dp[i],dp[i-1]+y);
            if (i%7==0) {
                dp[i]=Math.min(dp[i],dp[i/7]+x);
            }
            if (i%3==0) {
                dp[i]=Math.min(dp[i],dp[i/3]+z);
            }
            if (i%5==0) {
                dp[i]=Math.min(dp[i],dp[i/5]+b);
            }
        }
        ans=dp[n];
        return ans;
    }
    public static void main(String[] args) {
        int ans=minimumCost(15, 100, 1, 500, 10000000);
        System.out.println(ans);
    }
}
