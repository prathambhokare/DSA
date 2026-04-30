import java.util.*;

public class Solution1 {

    public static int countNumberOfValley(int[] nums) {
        int ans=0;
        int[] left=new int[nums.length];//_left[i] stores number strictly increasing sequence till index i from left to right
        int[] right=new int[nums.length];//_right[i] stores number strictly increasing sequence till index i from right to left
        Arrays.fill(left,1);
        Arrays.fill(right, 1);
        for (int i=1;i<nums.length;i++) {
            if (nums[i]<nums[i-1]) {
                left[i]=left[i-1]+1;
            }
            else {
                left[i]=1;
            }
        }
        for (int i=nums.length-2;i>=0;i--) {
            if (nums[i+1]>nums[i]) {
                right[i]=right[i+1]+1;
            }
            else {
                right[i]=1;
            }
        }
        for (int i=1;i<nums.length-1;i++) {
            ans=ans+((left[i]-1)*(right[i]-1));
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = countNumberOfValley(new int[]{3,1,2});
        System.out.println(ans);
    }
}