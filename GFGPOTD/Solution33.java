import java.util.Arrays;

public class Solution33 {

    public static int minimumcost(int[] cost,int w,int[] dp) {
        
        if (w<0) {
            return Integer.MAX_VALUE;
        }
        
        if (w==0) {
            return 0;
        }
        
        if (dp[w]!=Integer.MAX_VALUE) {
            return dp[w];
        }
        
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<cost.length;i++) {
            if (cost[i]!=-1) {
                int result=minimumcost(cost,w-(i+1),dp);
                if (result!=Integer.MAX_VALUE) {
                    ans=Math.min(ans,cost[i]+result);
                }
            }
        }
        return dp[w]=ans;
    }

    public static int minimumCost(int[] cost, int w) {
        // code here
        int[] dp=new int[w+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int result=minimumcost(cost,w,dp);
        if (result==Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int result=minimumCost(new int[]{20,10,4,50,100}, 5);
        System.out.println(result);
    }
}
