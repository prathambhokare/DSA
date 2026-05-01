package LEETCODEPOTD;

import java.util.*;

public class Solution1 {

    public static int rotateFunction(int i,int[] nums) {
        int ans=0;
        for (int j=0;j<nums.length;j++) {
            ans=ans+(nums[i%nums.length]*j);
            i=i+1;
        }
        return ans;
    }
    public static int maxRotateFunction(int[] nums) {
        //Brute Force Approach
        int ans=Integer.MIN_VALUE;
        // for (int i=0;i<nums.length;i++) {
        //     ans=Math.max(ans,rotateFunction(i,nums));//_calculate rotate function for each index
        // }
        int prevf=0;
        int numsum=0;
        for (int i=0;i<nums.length;i++) {
            prevf=prevf+i*nums[i];
            numsum=numsum+nums[i];
        }
        ans=Math.max(ans,prevf);
        for (int i=nums.length-1;i>=0;i--) {
            prevf=prevf+numsum-(nums.length)*nums[i];
            ans=Math.max(ans,prevf);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        int ans=maxRotateFunction(new int[]{4,3,2,6});
        System.out.println(ans);
    }
}
