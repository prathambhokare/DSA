import java.util.*;

public class Solution7 {
    
    //__find out/get maximum subarray sum which having difference between first and last element is K
    public static int maximumSubarraySum(int[] nums,int k) {
        int ans=Integer.MIN_VALUE;
        int[] dp=new int[nums.length];//__prefix sum ending at index i
        dp[0]=nums[0];
        // dp[1]=dp[0]+dp[1];
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(nums[0], 0);
        // if (mp.containsKey(nums[1])) {
        //    if (mp.get(nums[1])>dp[0]) {
        //     mp.put(nums[1], dp[0]);
        //    }
        // }
        // else {
        //     mp.put(nums[1], dp[0]);
        // }
        for (int i=1;i<nums.length;i++) {
            dp[i]=nums[i]+dp[i-1];
            if (mp.containsKey(nums[i]-k)) {
                ans=Math.max(ans,dp[i]-mp.get(nums[i]-k));
            }
            if (mp.containsKey(nums[i])) {
                if (mp.get(nums[i])>dp[i-1]) {
                    mp.put(nums[i], dp[i-1]);
                }
            }
            else {
                mp.put(nums[i], dp[i-1]);
            }
        }
        //y-x=k; then y=k+x
        return ans;
    }
    public static void main(String[] args) {
        int ans=maximumSubarraySum(new int[]{1,5,-5,8,8,8,10,15}, 5);
        System.out.println(ans);
    }
}
