package DP;

import java.util.*;

public class Solution2 {

    public static int maximumSubarraySum(int[] nums1,int[] nums2) {
        int ans=0;
        int[] dp=new int[nums1.length];//__maximum subarray sum till index i which including elements from both array
        dp[0]=Math.max(0,Math.max(nums1[0],nums2[0]));//__base_case
        dp[1]=Math.max(Math.max(nums1[1],nums2[1]),dp[0]);//__base_case
        for (int i=2;i<nums1.length;i++) {
            dp[i]=Math.max(Math.max(nums1[i], nums2[i])+dp[i-2],dp[i-1]);
        }
        ans=dp[nums1.length-1];
        return ans;
    }
    
    public static void main(String[] args) {
        int ans=maximumSubarraySum(new int[]{1,5,3,21234}, new int[]{-4509,200,3,40});
        System.out.println(ans);
    }
    
}
