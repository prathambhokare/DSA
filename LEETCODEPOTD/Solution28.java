package LEETCODEPOTD;

import java.util.*;

public class Solution28 {
    
    public static int minimumCost(int[] cost) {
        int ans=0;
        Arrays.sort(cost);
        int j=cost.length-1;
        while (j>=0) {
            if (j==0) {
                ans=ans+cost[0];
                return ans;
            }
            if (j-1==0) {
                ans=ans+cost[0]+cost[1];
                return ans;
            }
            ans=ans+cost[j]+cost[j-1];
            j=j-3;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans=minimumCost(new int[]{1,2,3});
        System.out.println(ans);
    }
}
