package LEETCODEPOTD;

import java.util.*;

public class Solution14 {

    public static boolean isGood(int[] nums) {
        boolean ans=false;
        int n=nums.length-1;
        Arrays.sort(nums);
        if (nums.length==1) {
            ans=false;
            return ans;
        }
        else if (nums[nums.length-1]!=n || nums[nums.length-2]!=n) {
            // System.out.println(nums[nums.length-1]);
            ans=false;
            return ans;
        }
        else {
            int i=0;
            while (i<nums.length-2) {
                // System.out.println(nums[i] + " " + i);
                if (nums[i]!=(i+1)) {
                    ans=false;
                    return ans;
                }
                i=i+1;
            }
        }
        ans=true;
        return ans;
    }

    public static void main(String[] args) {
        boolean ans=isGood(new int[]{2, 1, 3});
        System.out.println(ans);
    }
}
