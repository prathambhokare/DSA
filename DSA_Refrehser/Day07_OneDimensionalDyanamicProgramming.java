package DSA_Refrehser;

import java.util.*;;

public class Day07_OneDimensionalDyanamicProgramming {

    // ================= House Robber =================

    public int robAmount(int i,int[] nums,int[] memo) {

        if (i>=nums.length) {
            return 0;
        }

        if (memo[i]!=-1) {
            return memo[i];
        }

        return memo[i]=Math.max(
            nums[i]+robAmount(i+2,nums,memo),
            0+robAmount(i+1,nums,memo)
        );
    }

    public int rob(int[] nums) {

        int[] memo=new int[nums.length];
        Arrays.fill(memo,-1);

        return robAmount(0,nums,memo);
    }

    // ================= Min Cost Climbing Stairs =================

    public int minCostClimbingStairs(int[] cost) {

        int[] dp=new int[cost.length+1];

        dp[0]=cost[0];
        dp[1]=cost[1];

        for (int i=2;i<cost.length;i++) {

            dp[i]=cost[i]+Math.min(
                dp[i-1],
                dp[i-2]
            );
        }

        return Math.min(
            dp[cost.length-1],
            dp[cost.length-2]
        );
    }

    // ================= Decode Ways =================

    public boolean isValid(String ansval) {

        if (ansval.charAt(0)=='0') {
            return false;
        }

        int val=Integer.parseInt(ansval);

        if (val<1 || val>26) {
            return false;
        }

        return true;
    }

    public int numDecodings(String s) {

        int[] dp=new int[s.length()];

        for (int i=0;i<s.length();i++) {

            for (int j=i;j>=0;j--) {

                String ansval=s.substring(j,i+1);

                if (ansval.length()>2) {
                    break;
                }

                if (isValid(ansval)) {

                    if (j==0) {

                        if (ansval!="0") {
                            dp[i]=dp[i]+1;
                        }

                    }
                    else {
                        dp[i]=dp[i]+dp[j-1];
                    }
                }
            }
        }

        return dp[dp.length-1];
    }

    // ================= Test Cases =================

    public static void main(String[] args) {

        Day07_OneDimensionalDyanamicProgramming sol = new Day07_OneDimensionalDyanamicProgramming();

        System.out.println("===== House Robber =====");
        System.out.println(sol.rob(new int[]{1,2,3,1}));
        System.out.println(sol.rob(new int[]{2,7,9,3,1}));

        System.out.println();

        System.out.println("===== Min Cost Climbing Stairs =====");
        System.out.println(sol.minCostClimbingStairs(
            new int[]{10,15,20}
        ));

        System.out.println(sol.minCostClimbingStairs(
            new int[]{1,100,1,1,1,100,1,1,100,1}
        ));

        System.out.println();

        System.out.println("===== Decode Ways =====");
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("226"));
        System.out.println(sol.numDecodings("06"));
        System.out.println(sol.numDecodings("11106"));
    }
}
