import java.util.*;

public class Solution2 {
    //_Dynamic Size Sliding Window Problems
    //__Smallest Subarray with a Given Sum
    //__Longest Substring with K Distinct Characters
    //__Fruits into Baskets (LeetCode)
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int i=0;
        int j=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while (i<arr.length && j<arr.length) {
            sum=sum+arr[j];
            while (i<arr.length && sum>x) {
                ans=Math.min(ans,(j-i+1));
                // System.out.println("Window [: "  + (j-i+1));
                sum=sum-arr[i];
                i=i+1;
            }
            j=j+1;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static int longestKSubstr(String s, int k) {
        Map<Character,Integer> mp=new HashMap<>();//_stores frequecy of each character
        
    }

    public static void main(String[] args) {
        int ans = smallestSubWithSum(52, new int[]{1, 4, 45, 6, 0, 19});
        System.out.println(ans);
    }
}
