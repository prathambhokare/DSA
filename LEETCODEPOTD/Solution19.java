package LEETCODEPOTD;

import java.util.*;

public class Solution19 {
    
    public static int search(int[] nums, int target) {
        int ans=-1;
        int i=0;
        int j=nums.length-1;
        while (i<=j) {
            int mid=(i+j)/2;
            if (nums[mid]==target) {
                ans=mid;
                break;
            }
            //__check whether target left slant
            //arr[low......mid......high]
            //basically find out where mid is lies
            else if(nums[i]<=nums[mid]) {
                if(target>=nums[i] && target<nums[mid]) {
                    j=mid-1;
                }
                else {
                    i=mid+1;
                }
            }
            //__check whether target right slant
            else if(nums[mid]<=nums[j]) {
                if(nums[mid]<target && target<=nums[j]) {
                    i=mid+1;
                }
                else {
                    j=mid-1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(ans);
    }
}
