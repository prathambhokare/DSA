import java.util.*;

public class Solution8 {

    public static int countSubarrayWithMaximumK(int[] nums,int k) {
        int ans=0;
        Set<Integer> visited=new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==k && !visited.contains(i)) {
                //__traverse to left find out greater element
                int j=i;
                while (nums[j]<=k) {
                    visited.add(j);
                    j=j-1;
                }
                //__traverse to right find out greater element
                int x=i-j-1;
                // System.out.println(x + " -> " + j);
                j=i;
                while (nums[j]<=k) {
                    visited.add(j);
                    j=j+1;
                }
                int y=j-i-1;
                // System.out.print(x + " " + y);
                ans=ans+(x+1)*(y+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=countSubarrayWithMaximumK(new int[]{8,2,1,3,4,5,1,10}, 3);
        System.out.println(ans);
    }
}
