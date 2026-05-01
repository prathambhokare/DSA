import java.util.*;

public class Solution5 {

    //__The Get Number Of Pair Which Satisfies Below Condition
    //___Count How Many Pair Such Pairs a+k=b
    public static int countingPair(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (mp.containsKey(nums[i]-k)) {
                ans=ans+mp.get(nums[i]-k);
            }
            else {
                mp.put(nums[i],mp.getOrDefault(nums[i],    1));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=countingPair(new int[]{1,1,1,2}, 1);
        System.out.println(ans);
    }
}
