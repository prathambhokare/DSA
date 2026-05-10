package LEETCODEPOTD;

import java.util.*;

public class Solution10 {
    
    public static int[] dp;

    public static int maximumJumps(int idx,int[] nums,int target) {
        if (idx==nums.length-1) {
            return 0;
        }
        if (dp[idx]!=-2) {
            return dp[idx];
        }
        int maxJump=-1;
        //__Possible Jump From Index Idx
        for (int i=idx+1;i<nums.length;i++) {
            int diff=nums[i]-nums[idx];
            if (diff<=target && diff>=-target) {
                int ans=maximumJumps(i,nums,target);
                if (ans!=-1) {
                    maxJump=Math.max(maxJump,ans+1);
                }
            }
        }
        return dp[idx]=maxJump;
    }

    public static int maximumJumps(int[] nums, int target) {
        dp=new int[nums.length];
        Arrays.fill(dp,-2);
        return maximumJumps(0,nums,target);
    }

    public static void main(String[] args) {
        int ans=maximumJumps(new int[]{1,3,6,4,1,2}, 0);
        System.out.println(ans);
    }
}
