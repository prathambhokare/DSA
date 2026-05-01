import java.util.*;

public class Solution2 {
    
    /**
     * Find maximum sum of subset
     * __Where diff. adjs elements=diff. between indexes
     * @return maximum of subset
     */
    public static int subsetSumWithGivenCondition(int[] nums) {
        int ans=0;
        //__condition given arr[i]-arr[j]=i-j
        //____if we re-arrange then it become arr[i]-i=arr[j]-j
        int[] nums_copy=new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            nums_copy[i]=nums[i];
            nums[i]=nums[i]-i;
        }
        //__Now those element with same value are part of subset
        Map<Integer,Integer> mp=new HashMap<>();//__storing sum of subset
        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i],mp.getOrDefault(nums[i], 0)+nums_copy[i]);
        }
        //__Now get maximum sum among all subset
        for (Integer key : mp.keySet()) {
            ans=Math.max(ans,mp.get(key));
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=subsetSumWithGivenCondition(new int[]{1,5,3,7,8});
        System.out.println(ans);
    }
}
