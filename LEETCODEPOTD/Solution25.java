package LEETCODEPOTD;

import java.util.*;

public class Solution25 {
    
    public static int minElement(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++) {
            String ansval=String.valueOf(nums[i]);
            int sum=0;
            for (int j=0;j<ansval.length();j++) {
                sum=sum+(ansval.charAt(j)-'0');
            }
            ans=Math.min(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
       int ans=minElement(new int[]{10,12,13,14});
       System.out.println(ans);
    }
}
