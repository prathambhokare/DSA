package LEETCODEPOTD;

import java.util.HashMap;
import java.util.Map;

public class Solution68 {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        int i=0;
        int j=0;
        while (j<nums.length) {
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while (i<j && mp.get(nums[j])>k) {
                mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                i=i+1;
            }
            ans=Math.max(ans,j-i+1);
            j=j+1;
        }
        return ans;
    }
}
