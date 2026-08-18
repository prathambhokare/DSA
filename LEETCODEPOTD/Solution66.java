package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution66 {
    public int largestInteger(int[] nums, int k) {
        int ans=-1;
        Map<Integer,Integer> mp=new HashMap<>();
        int maxi=0;
        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            maxi=Math.max(maxi,nums[i]);
        }
        if (nums.length==k) {
            return maxi;
        }
        if (k==1) {
            maxi=0;
            boolean flag=false;
            for (Integer key : mp.keySet()) {
                if (mp.get(key)==1) {
                    flag=true;
                    maxi=Math.max(maxi,key);
                }
            }
            if (flag) {
                return maxi;
            }
        }
        int first=nums[0];
        int second=nums[nums.length-1];
        if (mp.get(first)==1) {
            ans=first;
        }
        if (second>first || ans==-1) {
            if (mp.get(second)==1) {
                ans=second;
            }
        }
        return ans;
    }
}
