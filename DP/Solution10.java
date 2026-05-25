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

    public static void main(String[] args) {
        int ans=numberOfWays(new int[]{1,3,2,1}, 4);
        System.out.println(ans);
    }
}
