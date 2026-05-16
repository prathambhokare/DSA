package LEETCODEPOTD;

import java.util.*;

public class Solution15 {

    public static int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int ans=0;
        while (i<j) {
            int mid=(i+j)/2;
            if (nums[mid]>nums[j]) {
                i=mid+1;
            }
            else if (nums[mid]<nums[j]) {
                j=mid;
            }
            else {
                j=j-1;
            }
        }
        // System.out.println(i + " " + j);
        return nums[i];
    }

    public static void main(String[] args) {
        int ans=findMin(new int[]{2,2,2,0,1});
        System.out.println(ans);
    }
}
