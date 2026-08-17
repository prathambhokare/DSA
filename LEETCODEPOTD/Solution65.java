package LEETCODEPOTD;

import java.util.Arrays;

class Solution {
    int[][] dp;
    int[] prefix;
    public int maxScore(int start,int end,int[] stoneValue) {
        if(start+1==end) {
            return 0;
        }
        if(dp[start][end]!=-1) {
            return dp[start][end];
        }
        int ans=0;
        for(int i=start;i<end-1;i++) {
            int leftRow=prefix[i+1]-prefix[start];
            int rightRow=prefix[end]-prefix[i+1];
            if(leftRow==rightRow) {
                ans=Math.max(
                    ans,
                    leftRow+
                    Math.max(
                        maxScore(start,i+1,stoneValue),
                        maxScore(i+1,end,stoneValue)
                    )
                );
            }
            else if(leftRow<rightRow) {

                ans=Math.max(
                    ans,
                    leftRow+
                    maxScore(start,i+1,stoneValue)
                );
            }
            else {

                ans=Math.max(
                    ans,
                    rightRow+
                    maxScore(i+1,end,stoneValue)
                );
            }
        }
        dp[start][end]=ans;
        return ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i],-1);
        }
        prefix=new int[n+1];
        for(int i=0;i<n;i++) {
            prefix[i+1]=prefix[i]+stoneValue[i];
        }
        return maxScore(0,n,stoneValue);
    }
}
