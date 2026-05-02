import java.util.*;

public class Solution6 {
 
    //__Given an array of size “N”; find the maximum value of triplet (i,j,k) such that |a[i] - a[j] - a[k]| + |i-j-k| is maximum. 
    public static int getMaximumValueOfTriplet(int[] nums) {
        int ans=0;
        //_update value each index of nums with indexs
        for (int i=0;i<nums.length;i++) {
            nums[i]=nums[i]+i;
        }
        for (int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
        Arrays.sort(nums);
        if (nums.length==1) {
            ans=nums[0]-(2*nums[0]);
        }
        else if (nums.length==2) {
            ans=nums[1]-(2*nums[0]);
        }
        else {
            ans=nums[nums.length-1] - (nums[0]+nums[1]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=getMaximumValueOfTriplet(new int[]{1,2,3,4,5});
        System.out.println(ans);
    }
}
