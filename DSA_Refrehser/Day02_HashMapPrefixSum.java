package DSA_Refrehser;

import java.util.HashMap;
import java.util.Map;

public class Day02_HashMapPrefixSum {
    
    public static int subarraySum(int[] nums, int k) {
        //x+y=k;
        //y=k-x;
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(ans,1);
        int prefixsum=0;
        for (int i=0;i<nums.length;i++) {
            prefixsum=prefixsum+nums[i];
            if (mp.containsKey(prefixsum-k)) {
                ans=ans+mp.get(prefixsum-k);
            }
            mp.put(prefixsum,mp.getOrDefault(prefixsum,0)+1);
        }
        return ans;
    }

    public static int longestSubarray(int[] arr, int k) {
        // code here
        //x+y=k;
        //y=k-x;
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(ans,-1);
        int prefixsum=0;
        for (int i=0;i<arr.length;i++) {
            prefixsum=prefixsum+arr[i];
            if (mp.containsKey(prefixsum-k)) {
                ans=Math.max(ans,(i-mp.get(prefixsum-k)));
            }
            if (!mp.containsKey(prefixsum)) {
                mp.put(prefixsum, i);
            }
        }
        return ans;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        boolean ans=false;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        int prefixsum=0;
        for (int i=0;i<nums.length;i++) {
            prefixsum=prefixsum+nums[i];
            if (mp.containsKey(prefixsum%k)) {
                if (i-mp.get(prefixsum%k)>=2) {
                    ans=true;
                    return ans;
                }
            }
            else {
                mp.put(prefixsum%k,i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int ans=subarraySum(new int[]{1,1,1}, 2);
        // System.out.println(ans);
        // int ans=longestSubarray(new int[]{10,5,2,7,1,-10},15);
        // System.out.println(ans);
        boolean ans=checkSubarraySum(new int[]{23,2,4,6,7}, 6);
        System.out.println(ans);
    }
}
