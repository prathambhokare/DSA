import java.util.*;

public class Solution3 {
    public static int getRemainder(int x,int y) {
        if (x>=0) return x%y;
        return (x%y+y);
    }
    public static int pairsDivisibleByK(int[] nums,int k) {
        int ans=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            mp.put(getRemainder(nums[i], k), mp.getOrDefault(getRemainder(nums[i], k),0)+1);
            if (mp.containsKey(k-getRemainder(nums[i], k))) {
                ans=ans+mp.get(k-getRemainder(nums[i], k));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=pairsDivisibleByK(new int[]{31,25,85,29,35}, 60);
        System.out.println(ans);
    }
}
