package DP;

import java.util.*;

public class Solution12 {
    
    public static int longestIncreasingSubsequences(int[] arr) {
        int ans=0;
        //__dp[i] is longest subsequences ending at index i
        int[] dp=new int[arr.length];
        //__every element is itself subsequences
        Arrays.fill(dp, 1);
        for (int i=0;i<arr.length;i++) {
            int ansval=0;
            for (int j=0;j<i;j++) {
                if (arr[j]<arr[i]) {
                    ansval=Math.max(ansval, dp[j]);
                }
            }
            dp[i]=ansval+1;
        }
        for (int i=0;i<dp.length;i++) {
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    public static int binarySearchLowerBound(List<Integer> subsequences,int target) {
        int i=0;
        int j=subsequences.size()-1;
        int ans=0;
        while (i<=j) {
            int mid=(i+j)/2;
            int ansval=subsequences.get(mid);
            if (ansval<=target) {
                i=mid+1;
            }
            else {
                ans=mid;
                j=mid-1;
            }
        }
        return ans;
    }

    public static int lowerBound(int[] arr,int target) {
        int ans=0;
        int i=0;
        int j=arr.length-1;
        while (i<=j) {
            int mid=(i+j)/2;
            if (arr[mid]>=target) {
                ans=mid;
                j=mid-1;
            }
            else {
                i=mid+1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr,int target) {
        int ans=0;
        int i=0;
        int j=arr.length-1;
        while (i<=j) {
            int mid=(i+j)/2;
            if (arr[mid]>target) {
                ans=mid;
                j=mid-1;
            }
            else {
                i=mid+1;
            }
        }
        return ans;
    }

    public static int longestIncreasingSubsequencesBinarySearch(int[] arr) {
        int ans=1;
        List<Integer> subsequences=new ArrayList<>();
        subsequences.add(arr[0]);
        for (int i=1;i<arr.length;i++) {
            if (subsequences.get(subsequences.size()-1)<arr[i]) {
                subsequences.add(arr[i]);
                ans=ans+1;
            }
            else {
                //__find position wherein arr[i] can be fit in subsequences
                int idx=binarySearchLowerBound(subsequences,arr[i]);
                System.out.println(idx+ " " + arr[i]);
                subsequences.set(idx, arr[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int ans=longestIncreasingSubsequences(new int[]{10,9,2,5,3,7,101,18});
        // System.out.println(ans);
        // int ans=longestIncreasingSubsequencesBinarySearch(new int[]{0,1,0,3,2,3});
        // System.out.println(ans);
        // int ans=lowerBound(new int[]{1,2,4,4,4,7,9}, 8);
        // System.out.println(ans);
        int ans=upperBound(new int[]{1,2,4,4,4,7,9}, 8);
        System.out.println(ans);
    }
}
