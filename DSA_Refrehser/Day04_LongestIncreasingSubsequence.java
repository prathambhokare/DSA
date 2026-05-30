import java.util.*;

public class Day04_LongestIncreasingSubsequence {

        public static int lowerBound(List<Integer> ansValues,int target) {
        int ans=0;
        int i=0;
        int j=ansValues.size()-1;
        while (i<=j) {
            int mid=j+(i-j)/2;
            if (ansValues.get(mid)>=target) {
                ans=mid;
                j=mid-1;
            }
            else {
                i=mid+1;
            }
        }
        return ans;
    }
    public static int lengthOfLISBinarySearch(int[] nums) {
        List<Integer> ansValues=new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            if (ansValues.isEmpty() || ansValues.get(ansValues.size()-1)<nums[i]) {
                ansValues.add(nums[i]);
            }
            else {
                int idx=lowerBound(ansValues,nums[i]);
                ansValues.set(idx,nums[i]);
            }
        }
        return ansValues.size();
    }
    public static int lengthOfLIS(int[] nums) {
        int ans=0;
        //__dp[i]=longest increasing subsequence ending at index "i"
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for (int i=0;i<nums.length;i++) {
            int maxLen=0;
            for (int j=0;j<i;j++) {
                if (nums[i]>nums[j]) {
                    maxLen=Math.max(maxLen,dp[j]); 
                }
            }
            dp[i]=Math.max(dp[i],1+maxLen);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int ans=lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        // System.out.println(ans);
        int ans=lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(ans);
    }
}