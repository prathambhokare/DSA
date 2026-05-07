package LEETCODEPOTD;

public class Solution7 {

    public static int[] maxValue(int[] nums) {

        int n=nums.length;

        int[] maxLeft=new int[n];
        int[] minRight=new int[n];

        //__max element from index 0 to i
        maxLeft[0]=nums[0];

        //__min element from index i to n-1
        minRight[n-1]=nums[n-1];

        for (int i=1;i<n;i++) {
            maxLeft[i]=Math.max(nums[i],maxLeft[i-1]);
        }

        for (int i=n-2;i>=0;i--) {
            minRight[i]=Math.min(nums[i],minRight[i+1]);
        }

        int[] ans=new int[n];

        ans[n-1]=maxLeft[n-1];

        for (int i=n-2;i>=0;i--) {

            //__can't move right
            if (maxLeft[i]<=minRight[i+1]) {
                ans[i]=maxLeft[i];
            }
            else {
                ans[i]=ans[i+1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = maxValue(new int[]{2,1,3});
        for (int i=0;i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
