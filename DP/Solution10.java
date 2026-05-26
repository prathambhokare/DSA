package DP;

import java.util.*;

public class Solution10 {
    
    public static int numberOfWays(int[] arr,int m) {
        int ans=0;
        int[] dp=new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            int sum=0;
            for (int j=i;j>=0;j--) {
                sum=sum+arr[j];
                if (sum<=m) {
                    dp[i]=dp[i]+(j-1<0?1:dp[j-1]);
                }
            }
        }
        for (int i=0;i<dp.length;i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        ans=dp[arr.length-1];
        return ans;
    }

    public static int numberOfWays(int[] arr,int m,int K) {
        int ans=0;
        //__number of ways to divide array till index i into k partition and having sum(part/piece)<=m
        int[][] dp=new int[arr.length][K+1];
        for (int i=0;i<arr.length;i++) {
            int sum=0;
            for (int j=i;j>=0;j--) {
                sum=sum+arr[j];
                if (sum>m) {
                    break;
                }
                if (j==0) {
                    dp[i][1]=dp[i][1]+1;
                }
                else {
                    for (int k=2;k<=K;k++) {
                        dp[i][k]=dp[i][k]+dp[j-1][k-1];
                    }
                }
            }
        }
        ans=dp[arr.length-1][K];
        return ans;
    }

    public static int minimumCost(int[] arr,int m) {
        //__minimum cost required to divide array into pieces such that each part/piece has value less than m
        int[] dp=new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i=0;i<arr.length;i++) {
            int lastElement=arr[i];
            int sum=0;
            for (int j=i;j>=0;j--) {
                sum=sum+arr[j];
                if (sum>m) {
                    break;
                }
                if (j==0) {
                    dp[i]=Math.min(dp[i],lastElement-0);
                }
                else {
                    dp[i]=Math.min(dp[i],dp[j-1]+lastElement-arr[j]);
                }
            }
        }
        for (int i=0;i<dp.length;i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[dp.length-1];
    }

    public static int minimumCost(int[] arr,int m,int K) {
        //__minimum cost required to divide array into pieces such that each part/piece has value less than m and only k partitions are allowed
        int[][] dp=new int[arr.length][K+1];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i=0;i<arr.length;i++) {
            int lastElement=arr[i];
            int sum=0;
            for (int j=i;j>=0;j--) {
                sum=sum+arr[j];
                if (sum>m) {
                    break;
                }
                if (j==0) {
                    //__for single element only one partition is allowed
                    dp[i][1]=Math.min(dp[i][1],lastElement-0);
                }
                else {
                    for (int k=2;k<=K;k++) {
                        dp[i][k]=Math.min(dp[i][k],dp[j-1][k-1]+lastElement-arr[j]);
                    }
                }
            }
        }
        return dp[arr.length-1][K];
    }

    public static boolean isPowerOfFive(String ansval) {

        if (ansval == null || ansval.length() == 0) {
            return false;
        }
        // convert binary string to decimal
        long num = Long.parseLong(ansval, 2);
        // powers of 5 are always positive
        if (num <= 0) {
            return false;
        }
        // keep dividing by 5
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static int minimumBeautifulSubstrings(String s) {
        int ans=0;
        //__minimum beautiful substrings till index i
        int[] dp=new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0;i<s.length();i++) {
            for (int j=i;j>=0;j--) {
                if (s.charAt(j) == '0') {
                    continue;
                }
                String ansval = s.substring(j, i + 1);
                if (isPowerOfFive(ansval)) {
                    if (j==0) {
                        dp[i]=1;
                    }
                    else if (dp[j-1]!=Integer.MAX_VALUE) {
                        dp[i]=Math.min(dp[i],1+dp[j-1]);
                    }
                }
            }
        }
        ans=dp[dp.length-1]==Integer.MAX_VALUE ? -1 : dp[dp.length-1];
        return ans;
    }

    public static int minimumSumOfMaximumElementOfPartitions(int[] arr,int K) {
        int ans=Integer.MAX_VALUE;
        //__minimum possible answer for first (0...i) elements using exactly k partitions
        int[][] dp=new int[arr.length][K+1];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i=0;i<arr.length;i++) {
            int maxElement=0;
            for (int j=i;j>=0;j--) {
                maxElement=Math.max(maxElement, arr[j]);
                if (j==0) {
                    dp[i][1]=maxElement;
                }
                else {
                    for (int k=2;k<=K;k++) {
                        if (dp[j-1][k-1]!=Integer.MAX_VALUE) {
                            dp[i][k]=Math.min(
                                dp[i][k],
                                maxElement + dp[j-1][k-1]
                            );
                        }
                    }
                }
            }
        }
        ans=dp[arr.length-1][K];
        return ans;
    }

    public static boolean isBalancedSubstring(int[] freq) {
        int expected = 0;
        for (int count : freq) {
            if (count == 0) {
                continue;
            }
            if (expected == 0) {
                expected = count;
            }
            else if (expected != count) {
                return false;
            }
        }
        return true;
    }
    public static int minimumSubstringsInPartition(String s) {
       int[] dp=new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0;i<s.length();i++) {
            int[] freq = new int[26];
            for (int j=i;j>=0;j--) {
                freq[s.charAt(j) - 'a']++;
                if (isBalancedSubstring(freq)) {
                    if (j==0) {
                        dp[i]=1;
                    }
                    else if (dp[j-1]!=Integer.MAX_VALUE) {
                        dp[i]=Math.min(dp[i],1+dp[j-1]);
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        // int ans=numberOfWays(new int[]{1,3,2,1}, 4,4);
        // System.out.println(ans);
        // int ans=minimumBeautifulSubstrings("1011");
        // System.out.println(ans);
        // int ans=minimumSumOfMaximumElementOfPartitions(new int[]{3, 1, 2, 4}, 2);
        // System.out.println(ans);
        int ans=minimumSubstringsInPartition("fabccddg");
        System.out.println(ans);
    }
}
