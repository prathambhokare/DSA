package DP;

import java.util.*;

public class Solution1 {
    
    public static int maximumSubarraySumWithNoTwoAdjacent(int[] nums) {
        int ans=0;
        int[] dp=new int[nums.length];//_dp array which stores ith index optimal answer
        dp[0]=Math.max(nums[0],0);//__base case 01: when nums[0]<0 then consider picking up no elements
        dp[1]=Math.max(nums[1],dp[0]);
        for (int i=2;i<nums.length;i++) {
            dp[i]=Math.max(
                dp[i-1], //__not include current element in answer
                dp[i-2]+nums[i] //__include current element in answer then we are not allowed choose adjacent element
            );
        }
        ans=dp[nums.length-1];
        return ans;
    }
    public static void main(String[] args) {
        int ans=maximumSubarraySumWithNoTwoAdjacent(new int[]{2,-3,5,-8,7});
        System.out.println(ans);
    }
}
