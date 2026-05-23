package LEETCODEPOTD;

import java.util.*;

public class Solution20 {
    
    public static boolean check(int[] nums) {
        
        int index=0;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]<nums[i-1]) {
                index=i;
            }
        }

        int count=nums.length-1;
        while (count>0) {
            if (nums[index%nums.length]>nums[(index+1)%nums.length]) {
                return false;
            }
            index=index+1;
            count=count-1;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans=check(new int[]{3,4,5,1,2});
        System.out.println(ans);
    }
}
