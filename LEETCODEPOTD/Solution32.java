package LEETCODEPOTD;

public class Solution32 {
    public int[] leftRightDifference(int[] nums) {
        int[] ans=new int[nums.length];
        int sum=0;
        for (int i=0;i<nums.length;i++) {
            sum=sum+nums[i];
        }
        int ansval=0;
        for (int i=0;i<nums.length;i++) {
            if (i==0 || i==nums.length-1) {
                ans[i]=sum-nums[i];
            }
            else {
                int leftpart=ansval;
                int rightpart=sum-ansval-nums[i];
                // System.out.println(sum + " " + ansval + " " + nums[i]);
                ans[i]=Math.abs(rightpart-leftpart);
            }
            ansval=ansval+nums[i];
        }
        return ans;
    }
}
