package DP;

public class Solution10 {
    
    public static int numberOfWays(int[] arr,int m) {
        int ans=0;
        int[] dp=new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            int sum=0;
            for (int j=i;j>=0;j--) {
                sum=sum+arr[j];
                if (sum<=m) {
                    dp[i]=dp[i]+(j-1<0?1:dp[j-1]);
                }
            }
        }
        for (int i=0;i<dp.length;i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        ans=dp[arr.length-1];
        return ans;
    }

    public static int numberOfWays(int[] arr,int m,int K) {
        int ans=0;
        //__number of ways to divide array till index i into k partition and having sum(part/piece)<=m
        int[][] dp=new int[arr.length][K+1];
        for (int i=0;i<arr.length;i++) {
            int sum=0;
            for (int j=i;j>=0;j--) {
                sum=sum+arr[j];
                if (sum>m) {
                    break;
                }
                if (j==0) {
                    dp[i][1]=dp[i][1]+1;
                }
                else {
                    for (int k=2;k<=K;k++) {
                        dp[i][k]=dp[i][k]+dp[j-1][k-1];
                    }
                }
            }
        }
        ans=dp[arr.length-1][K];
        return ans;
    }

    public static void main(String[] args) {
        int ans=numberOfWays(new int[]{1,3,2,1}, 4,4);
        System.out.println(ans);
    }
}
