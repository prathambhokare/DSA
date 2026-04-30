import java.util.*;

public class Solution1 {
    
    //_Fixed Size Slinding Window Problems
    //__Maximum Sum Subarray of Size K
    //__First Negative Integer in Every Window of Size K
    //__Average of Subarrays of Size K
    public static int maximumSubarraySum(int[] arr, int k) {

        int i=0;
        int j=0;
        int windowSum=0;
        int ans=0;
        for (j=0;j<k;j++) {
            windowSum=windowSum+arr[j];
        }
        ans=Math.max(ans,windowSum);
        for (j=k;j<arr.length;j++) {
            windowSum=windowSum-arr[i];
            i=i+1;
            windowSum=windowSum+arr[j];
            ans=Math.max(ans,windowSum);
            System.out.println("Window Size :[ " + (j-i+1)  + "]");
        }
        return ans;
    }
    public static void main(String[] args) {
        int k=3;
        int ans = maximumSubarraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8},k);
        System.out.println(ans);
    }
}
