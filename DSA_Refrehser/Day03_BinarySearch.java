package DSA_Refrehser;

import java.util.*;

public class Day03_BinarySearch {

    public static int binarySearch(int[] arr,int target) {
        int ans=-1;
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while (i<=j) {
            int mid=i+(j-i)/2;
            if (arr[mid]<target) {
                i=mid+1;
            }
            else if (arr[mid]==target) {
                ans=mid;
                return ans;
            }
            else {
                j=mid-1;
            }
        }
        return ans;
    }

    public static int lowerBound(int[] arr,int target) {
        int ans=-1;
        //first element such that arr[i]>=target
        int i=0;
        int j=arr.length-1;
        while (i<=j) {
            int mid=i+(j-i)/2;
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
        int ans=-1;
        int i=0;
        int j=arr.length-1;
        while (i<=j) {
            int mid=i+(j-i)/2;
            if (arr[mid]>target) {
                ans=mid;
                j=mid-1;
            }
            else {
                i=mid+1;
            }
        }
        return ans==-1?arr.length:ans;
    }
    
    public static int search(int[] nums, int target) {
        int ans=-1;
        int i=0;
        int j=nums.length-1;
        while (i<=j) {
            int mid=i+(j-i)/2;
            if (nums[mid]==target) {
                ans=mid;
                return ans;
            }
            else if (nums[mid]>=nums[i]) {
                if (nums[mid]>target && target>=nums[i]) {
                    j=mid-1;
                }
                else {
                    i=mid+1;
                }
            }
            else {
                if (nums[mid]<target && nums[j]>=target) {
                    i=mid+1;
                }
                else {
                    j=mid-1;
                }
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours = totalHours+ (int)Math.ceil((double)pile / k);;
            if (totalHours > h) {
                return false;
            }
        }
        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int ans=0;
        int minK=1;
        int maxK=Integer.MIN_VALUE;
        for (int i=0;i<piles.length;i++) {
            maxK=Math.max(maxK,piles[i]);
        }
        // System.out.println(minK + " " + maxK);
        while (minK<=maxK) {
            int mid=(minK+maxK)/2;
            if (isPossible(piles,h,mid)) {
                ans=mid;
                maxK=mid-1;
            }
            else {
                minK=mid+1;
            }
        }
        return ans==0?maxK:ans;
    }

    public static void main(String[] args) {
        // int ans=binarySearch(new int[]{1,2,3,4,5,7,8,9}, 10);
        // System.out.println(ans);
        // int ans=lowerBound(new int[]{1,2,3,4,5,7,9}, 0);
        // System.out.println(ans);
        // int ans=upperBound(new int[]{1,2,3,4,5,7,9}, 0);
        // System.out.println(ans);
        // int ans=search(new int[]{4,5,6,7,0,1,2}, 0);
        // System.out.println(ans);
        int ans=minEatingSpeed(new int[]{3,6,7,11}, 8);
        System.out.println(ans);
    }
}
